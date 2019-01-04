package com.jsj.sword_for_offer.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque1 = new LinkedList<>();
        deque1.addLast(root);
        TreeNode now;
        for (Deque<TreeNode> deque2 = new LinkedList<>(), deque; !(deque1.isEmpty() && deque2.isEmpty()); ) {
            if (deque1.isEmpty()) {
                deque = deque1;
                deque1 = deque2;
                deque2 = deque;
            }
            now = deque1.pollFirst();
            list.add(now.val);
            if (now.left != null) {
                deque2.addLast(now.left);
            }
            if (now.right != null) {
                deque2.addLast(now.right);
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
