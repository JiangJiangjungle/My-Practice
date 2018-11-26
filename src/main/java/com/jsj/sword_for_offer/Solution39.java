package com.jsj.sword_for_offer;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution39 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        return IsBalanced_Solution(root.left) &&
                IsBalanced_Solution(root.right) &&
                (leftDepth - rightDepth <= 1) &&
                (leftDepth - rightDepth >= -1);
    }

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
