package com.jsj.leetcode.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 思路：层序遍历迭代：根据reverse判断正序取元素还是倒序取元素，然后使下一层的元素仍然保持有序排列
 *
 * @author jsj
 * @date 2019-05-11
 */
public class Solution103 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque1 = new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();
        deque1.offerLast(root);
        boolean reverse = false;
        for (Deque<TreeNode> tmp; !deque1.isEmpty(); tmp = deque1, deque1 = deque2, deque2 = tmp, reverse = !reverse) {
            List<Integer> aList = new ArrayList<>();
            for (; !deque1.isEmpty(); ) {
                //正序取元素还是倒序取元素
                TreeNode node = reverse ? deque1.pollLast() : deque1.pollFirst();
                aList.add(node.val);
                //使下一层的元素仍然保持有序排列
                if (reverse) {
                    if (node.right != null) {
                        deque2.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque2.offerFirst(node.left);
                    }
                } else {
                    if (node.left != null) {
                        deque2.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque2.offerLast(node.right);
                    }
                }
            }
            list.add(aList);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        head.left.left.left = new TreeNode(8);
        head.left.left.right = new TreeNode(9);
        head.left.right.left = new TreeNode(10);
        head.left.right.right = new TreeNode(11);
        List<List<Integer>> list = new Solution103().zigzagLevelOrder(head);
        for (List<Integer> aList : list) {
            System.out.println(Arrays.toString(aList.toArray()));
        }
    }
}
