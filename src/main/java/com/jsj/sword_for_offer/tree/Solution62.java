package com.jsj.sword_for_offer.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：给定一颗二叉搜索树，请找出其中的第k大的结点。例如，
 * 5
 * / \
 * 3 7
 * /\ /\
 * 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4
 * 。
 * 思路：中序遍历
 */
public class Solution62 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> record = new ArrayDeque<>(k);
        deque.addLast(pRoot);
        A:
        for (TreeNode node; !deque.isEmpty(); ) {
            for (node = deque.peekLast(); node.left != null; ) {
                node = node.left;
                deque.addLast(node);
            }
            do {
                node = deque.pollLast();
                if (node == null) break A;
                record.addLast(node);
                if (record.size() == k) {
                    break A;
                }
            } while (node.right == null);
            deque.addLast(node.right);
        }
        if (record.size() < k) {
            return null;
        }
        return record.pollLast();
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.right.left = new TreeNode(9);
        node.right.left.left = new TreeNode(7);
        node.right.right = new TreeNode(11);
        solution62.KthNode(node, 8);
    }
}
