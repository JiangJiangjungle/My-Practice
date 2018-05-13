package com.jsj.nowcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution61 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    String Serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode node;
        while (!stack1.empty() || !stack2.empty()) {
            while (!stack1.empty()) {
                node = stack1.pop();
                if (node != null) {
                    sb.append(String.valueOf(node.val)+",");
                    stack2.push(node.left);
                    stack2.push(node.right);
                } else {
                    sb.append("#,");
                }
            }
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        String s = sb.toString();
        if (s.endsWith("#,")) {
            char[] chars = s.toCharArray();
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] <= '9' && chars[i] >= '0') index = i;
            }
            return s.substring(0,index+1);
        } else {
            return sb.substring(0, sb.length() - 1);
        }
    }

    TreeNode Deserialize(String str) {
        if (str.startsWith("#")) return null;
        String[] strings = str.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));

        TreeNode now = root;
        LinkedList<TreeNode> list = new LinkedList<>();
        int count = 0;
        for (int i = 1; i < strings.length ; i++) {
            if (!strings[i].equals("#")) {
                if (count == 0) {
                    now.left = new TreeNode(Integer.valueOf(strings[i]));
                    list.add(now.left);
                    count++;
                } else {
                    now.right = new TreeNode(Integer.valueOf(strings[i]));
                    list.add(now.right);
                    now = list.removeFirst();
                    count = 0;
                }
            } else {
                if (count == 0) {
                    now.left = null;
                    count++;
                } else {
                    now.right = null;
                    now = list.removeFirst();
                    count = 0;
                }
            }
        }
        return root;
    }
}
