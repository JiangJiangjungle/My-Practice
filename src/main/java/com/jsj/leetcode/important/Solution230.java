package com.jsj.leetcode.important;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * <p>
 * 思路：中序遍历
 */
public class Solution230 {
    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeNode t = root;
        for (; !deque.isEmpty(); ) {
            for (TreeNode tmp = deque.pollLast(); tmp != null; tmp = tmp.left) {
                deque.addLast(tmp);
            }
            do {
                t = deque.pollLast();
                k--;
                if (k == 0) {
                    return t.val;
                }
            } while (t.right == null);
            deque.addLast(t.right);
        }
        return t.val;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 3));
    }
}
