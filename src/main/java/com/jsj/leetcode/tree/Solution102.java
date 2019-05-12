package com.jsj.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 思路：利用层序遍历进行迭代
 *
 * @author jsj
 * @date 2019-05-11
 */
public class Solution102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        for (int len = 1, lenCount; !deque.isEmpty(); len = lenCount) {
            lenCount = 0;
            List<Integer> aList = new ArrayList<>(len);
            for (int count = 0; count < len; count++) {
                TreeNode node = deque.pollFirst();
                aList.add(node.val);
                if (node.left != null) {
                    lenCount++;
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    lenCount++;
                    deque.offerLast(node.right);
                }
            }
            list.add(aList);
        }
        return list;
    }
}
