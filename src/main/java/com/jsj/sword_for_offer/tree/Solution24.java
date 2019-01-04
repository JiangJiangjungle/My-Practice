package com.jsj.sword_for_offer.tree;

import java.util.*;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 思路：利用后序遍历找到所有叶子节点并判断
 */
public class Solution24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(root.val);
        doFindPath(root, target, deque, list);
        return list;
    }

    private void doFindPath(TreeNode root, int target, Deque<Integer> deque, ArrayList<ArrayList<Integer>> list) {
        if (root == null) return;
        target -= root.val;
        if (target < 0) return;
        if (root.left == null && root.right == null) {
            if (target == 0) list.add(new ArrayList<>(deque));
            return;
        }
        TreeNode node = root.left;
        if (node != null) {
            deque.addLast(node.val);
            doFindPath(node, target, deque, list);
            deque.pollLast();
        }
        node = root.right;
        if (node != null) {
            deque.addLast(node.val);
            doFindPath(node, target, deque, list);
            deque.pollLast();
        }
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
