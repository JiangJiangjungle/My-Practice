package com.jsj.sword_for_offer.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution38 {
    public int TreeDepth(TreeNode root) {
        int depth = 0;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        while (root != null) {
            stack.push(root);
            root = root.left;
            count++;
        }
        TreeNode now;
        Set<TreeNode> tags = new HashSet<>();
        while (!stack.empty()) {
            now = stack.pop();
            if (now.right != null && !tags.contains(now)) {
                tags.add(now);
                stack.push(now);
                now = now.right;
                while (now != null) {
                    stack.push(now);
                    count++;
                    now = now.left;
                }
                continue;
            } else if (now.right == null && count > depth) {
                depth = count;
            }
            count--;
        }
        return depth;
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
