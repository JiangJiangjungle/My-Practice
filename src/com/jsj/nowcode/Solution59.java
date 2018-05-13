package com.jsj.nowcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        stack.push(pRoot);
        ArrayList<Integer> aList;
        TreeNode now;
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack.empty() || !stack2.empty()) {
            if (!stack.empty()) {
                aList = new ArrayList<>();
                while (!stack.empty()) {
                    now = stack.pop();

                    aList.add(now.val);
                    if (now.left != null) {
                        stack2.push(now.left);
                    }
                    if (now.right != null) {
                        stack2.push(now.right);
                    }
                }
                result.add(aList);
            }
            if (!stack2.empty()) {
                aList = new ArrayList<>();
                while (!stack2.empty()) {
                    now = stack2.pop();

                    aList.add(now.val);
                    if (now.right != null) {
                        stack.push(now.right);
                    }
                    if (now.left != null) {
                        stack.push(now.left);
                    }
                }
                result.add(aList);
            }
        }
        return result;
    }
}
