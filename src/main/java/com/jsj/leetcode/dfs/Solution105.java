package com.jsj.leetcode.dfs;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 思路：利用分治。
 *
 * @author jsj
 * @date 2019-05-15
 */
public class Solution105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end3) {
        if (start1 > end1 || start2 > end3) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start1]);
        int len = 0;
        for (int x = start2; inorder[x] != preorder[start1]; len++, x++) {
        }
        root.left = buildTree(preorder, start1 + 1, start1 + len, inorder, start2, start2 + len - 1);
        root.right = buildTree(preorder, start1 + len + 1, end1, inorder, start2 + len + 1, end3);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new Solution105().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println(node.val);
    }
}
