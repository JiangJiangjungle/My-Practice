package com.jsj.sword_for_offer.print;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 *
 * 题目描述：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
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
            while (!stack2.empty()) {
                stack.push(stack2.pop());
            }
        }
        return result;
    }
}
