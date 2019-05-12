package com.jsj.leetcode.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author jsj
 * @date 2019-05-09
 */
public class Solution94 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        for (; !deque.isEmpty(); ) {
            for (TreeNode node = deque.pollLast(); node != null; node = node.left) {
                deque.offerLast(node);
            }
            for (TreeNode node = deque.pollLast(); node != null; node = deque.pollLast()) {
                list.add(node.val);
                if (node.right != null) {
                    deque.offerLast(node.right);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = new Solution94().inorderTraversal(root);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
