package com.jsj.leetcode.dp;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * <p>
 * 思路：f(n)=min{f(n-1)+f(1),f(n-2)+f(2),...,f(n-n/2)+f(n/2)};
 */
public class Solution279 {
    public int numSquares(int n) {
        for (int j = 1; j <= Math.sqrt(n); j++) {
            if (j * j == n) {
                return 1;
            }
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (j * j == i) {
                    dp[i] = 1;
                    break;
                }
            }
            if (dp[i] == 1) continue;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                int tmp = dp[j] + dp[i - j];
                if (min > tmp) {
                    min = tmp;
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(12));
    }
}
