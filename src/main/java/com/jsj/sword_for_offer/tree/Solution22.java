package com.jsj.sword_for_offer.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        for (int size = 1; !deque.isEmpty(); size = deque.size()) {
            TreeNode node;
            for (int count = 0; count < size; count++) {
                node = deque.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }
        }
        return list;
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
