package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return doReConstruct(in, pre, 0, pre.length - 1, 0);
    }

    private TreeNode doReConstruct(int[] in, int[] pre, int begin1, int end1, int begin2) {
        if (end1 <= begin1) {
            if (end1 == begin1) {
                return new TreeNode(in[begin1]);
            }
            return null;
        }
        int target = pre[begin2];
        TreeNode result = new TreeNode(target);
        int index = 0;
        for (int i = begin1; i <= end1; i++) {
            if (in[i] == target) index = i;
        }
        result.left = doReConstruct(in, pre, begin1, index - 1, begin2 + 1);
        result.right = doReConstruct(in, pre, index + 1, end1, begin2 + 1 + index - begin1);
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
