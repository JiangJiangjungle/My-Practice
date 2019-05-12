package com.jsj.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 思路：中序遍历
 *
 * @author jsj
 * @date 2019-05-09
 */
public class Solution98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        boolean valid = true;
        if (root == null) {
            return valid;
        }
        boolean started = false;
        int lastVal = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        A:
        for (; !deque.isEmpty(); ) {
            for (TreeNode node = deque.pollLast(); node != null; node = node.left) {
                deque.offerLast(node);
            }
            for (TreeNode node = deque.pollLast(); node != null; node = deque.pollLast()) {
                if (!started) {
                    started = true;
                } else if (node.val <= lastVal) {
                    valid = false;
                    break A;
                }
                lastVal = node.val;
                if (node.right != null) {
                    deque.offerLast(node.right);
                    break;
                }
            }
        }
        return valid;
    }
}
