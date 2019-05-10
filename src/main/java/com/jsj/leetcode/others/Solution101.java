package com.jsj.leetcode.others;

import com.sun.istack.internal.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * <p>
 * 思路：递归法或者利用层序遍历进行迭代
 *
 * @author jsj
 * @date 2019-05-10
 */
public class Solution101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    /**
     * 递归
     *
     * @param left
     * @param right
     * @return
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || left == null && right != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 层序遍历实现迭代
     *
     * @param left
     * @param right
     * @return
     */
    private boolean isSymmetric2(TreeNode left, TreeNode right) {
        boolean symmetric = true;
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || left == null && right != null) {
            return false;
        }
        Deque<TreeNode> deque1 = new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();
        deque1.offerFirst(left);
        deque2.offerFirst(right);
        for (TreeNode node1, node2; !deque1.isEmpty() && !deque2.isEmpty(); ) {
            node1 = deque1.pollFirst();
            node2 = deque2.pollFirst();
            if (node1.val != node2.val ||
                    node1.left != null && node2.right == null ||
                    node1.left == null && node2.right != null ||
                    node1.right != null && node2.left == null ||
                    node1.right == null && node2.left != null) {
                symmetric = false;
                break;
            }
            if (node1.left != null && node2.right != null) {
                deque1.offerLast(node1.left);
                deque2.offerLast(node2.right);
            }
            if (node1.right != null && node2.left != null) {
                deque1.offerLast(node1.right);
                deque2.offerLast(node2.left);
            }
        }
        return symmetric;
    }


}
