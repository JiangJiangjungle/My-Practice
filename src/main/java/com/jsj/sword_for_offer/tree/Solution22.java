package com.jsj.sword_for_offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        list.add(root.val);
        if (root.left != null) {
            queue.add(root.left);
        }
        if (root.right != null) {
            queue.add(root.right);
        }
        TreeNode now;
        while (!queue.isEmpty()) {
            now = queue.remove();
            list.add(now.val);
            if (now.left != null) {
                queue.add(now.left);
            }
            if (now.right != null) {
                queue.add(now.right);
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
