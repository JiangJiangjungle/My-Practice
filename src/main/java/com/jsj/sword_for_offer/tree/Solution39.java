package com.jsj.sword_for_offer.tree;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution39 {

    public boolean IsBalanced_Solution(TreeNode root) {
        return doBalancedSolution(root) >= 0;
    }

    public int doBalancedSolution(TreeNode root) {
        if (root == null) return 0;
        int left = doBalancedSolution(root.left);
        if (left == -1) return left;
        int right = doBalancedSolution(root.right);
        if (right == -1) return right;
        return Math.abs(right - left) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
