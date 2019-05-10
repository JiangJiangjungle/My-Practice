package com.jsj.leetcode.others;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 思路：中序遍历，找到两个失序节点
 *
 * @author jsj
 * @date 2019-05-10
 */
public class Solution99 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 利用中序遍历解决，空间复杂度O(n)
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        TreeNode prev = null, leftNode = null, rightNode = null;
        A:
        for (boolean firstTravel = true; !deque.isEmpty(); ) {
            for (TreeNode node = deque.pollLast(); node != null; node = node.left) {
                deque.offerLast(node);
            }
            for (TreeNode node = deque.pollLast(); node != null; node = deque.pollLast()) {
                //找到失序节点
                if (prev != null && node.val < prev.val) {
                    if (firstTravel) {
                        //确定找到第1个的失序节点
                        leftNode = prev;
                        //不确定找到第1个的失序节点
                        rightNode = node;
                        firstTravel = false;
                    } else {
                        //确定找到第2个的失序节点
                        rightNode = node;
                        break A;
                    }
                }
                prev = node;
                if (node.right != null) {
                    deque.offerLast(node.right);
                    break;
                }
            }
        }
        if (leftNode != null && rightNode != null) {
            int tmp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = tmp;
        }
    }

}
