package main.java.com.jsj.sword_for_offer;

import java.util.Stack;

/**@author jsj
 * @since 2018-5-12
 * 题目描述：给定一颗二叉搜索树，请找出其中的第k大的结点。例如，
 *    5
 *   / \
 *   3 7
 *  /\ /\
 * 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4
 * 。
 * 思路：中序遍历
 */
public class Solution62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = pRoot;
        int count = 0;
        while (now != null) {
            stack.push(now);
            now = now.left;
        }
        while (!stack.empty()) {
            now = stack.pop();
            count++;
            if (count == k) {
                return now;
            }
            if (now.right != null) {
                now = now.right;
                while (now != null) {
                    stack.push(now);
                    now = now.left;
                }
            }
        }
        return null;
    }
}
