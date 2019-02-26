package com.jsj.leetcode.important;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输出: 42
 * <p>
 * 思路：定义getMax方法，返回经过节点r的最大路径和；通过递归遍历所有节点。得到最大路径和
 */
public class Solution124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //当前最大路径和
    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        /**
         对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
         2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
         **/
        getMax(root);
        return ret;
    }

    /**
     * 返回值：经过r节点的最大路径和（同时在递归调用过程中，会遍历经过所有r的子节点的最大路径和并更新ret）
     *
     * @param r
     * @return
     */
    private int getMax(TreeNode r) {
        if (r == null) return 0;
        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int left = Math.max(0, getMax(r.left));
        int right = Math.max(0, getMax(r.right));
        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        ret = Math.max(ret, r.val + left + right);
        return Math.max(left, right) + r.val;
    }
}
