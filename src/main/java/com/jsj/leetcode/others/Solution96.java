package com.jsj.leetcode.others;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 思路：f(n) = 1到n求和,第i项：f(i-1)*f(n-i)
 *
 * @author jsj
 * @date 2019-05-09
 */
public class Solution96 {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] record = new int[n + 1];
        record[0] = 1;
        record[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                record[i] += record[j - 1] * record[i - j];
            }
        }
        return record[n];
    }

    public static void main(String[] args) {
        int val = new Solution96().numTrees(3);
        System.out.println(val);
    }
}
