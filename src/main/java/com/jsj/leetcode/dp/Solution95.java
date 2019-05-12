package com.jsj.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * 思路：遍历：
 *      从1到n，第i个值为根节点，分别求出1-（i-1）的所有节点集合，作为左边子节点；求出（i+1)-n的所有节点集合，作为右边子节点；
 *
 * @author jsj
 * @date 2019-05-09
 */
public class Solution95 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        List<TreeNode> tmp, tmp2;
        TreeNode node;
        for (int i = start; i <= end; i++) {
            tmp = generateTrees(i + 1, end);
            tmp2 = generateTrees(start, i - 1);
            for (TreeNode rightNode : tmp) {
                for (TreeNode leftNode : tmp2) {
                    node = new TreeNode(i);
                    node.right = rightNode;
                    node.left = leftNode;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
