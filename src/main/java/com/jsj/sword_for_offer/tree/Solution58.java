package com.jsj.sword_for_offer.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || pRoot.left == null && pRoot.right == null) return true;
        if (pRoot.right == null || pRoot.left == null) return false;
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        deque1.addLast(pRoot.left);
        deque2.addLast(pRoot.right);
        return doIsSymmetrical(deque1, deque2);
    }

    private boolean doIsSymmetrical(Deque<TreeNode> deque1, Deque<TreeNode> deque2) {
        boolean symmetrical = true;
        for (TreeNode left, right; !(deque1.isEmpty() && deque2.isEmpty()); ) {
            if (!deque1.isEmpty() && !deque2.isEmpty()) {
                left = deque1.pollFirst();
                right = deque2.pollFirst();
                if (check(left, right)) {
                    if (left.left != null) {
                        deque1.addLast(left.left);
                        deque2.addLast(right.right);
                    }
                    if (left.right != null) {
                        deque1.addLast(left.right);
                        deque2.addLast(right.left);
                    }
                    continue;
                }
            }
            symmetrical = false;
            break;
        }
        return symmetrical;
    }

    private boolean check(TreeNode temp1, TreeNode temp2) {
        if (temp1.val != temp2.val) return false;
        if (temp1.left != null && temp2.right == null) {
            return false;
        }
        if (temp1.right != null && temp2.left == null) {
            return false;
        }
        if (temp2.left != null && temp1.right == null) {
            return false;
        }
        if (temp2.right != null && temp1.left == null) {
            return false;
        }
        return true;
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
