package com.jsj.leetcode.dp;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的最少分割次数。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 思路：用二维数组A[i][j]表示s[i..j]是否为回文串；
 * 遍历，若s[j..i-1]为回文串，那么dp[i] = Math.min(dp[j] + 1, dp[i]);
 *
 * @author jsj
 * @date 2019-05-13
 */
public class Solution132 {
    public int minCut(String s) {
        //A[i][j]表示s[i..j]是否为回文串
        boolean[][] A = new boolean[s.length()][s.length()];
        int i, j;
        for (int t = 0; t < s.length(); t++) {
            //奇数长度回文串，以中心点为中心，分别向左右判断
            i = j = t;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                A[i][j] = true;
                i--;
                j++;
            }
            //偶数长度回文串，以连续两个点为中心，分别向左右判断
            i = t;
            j = t + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                A[i][j] = true;
                i--;
                j++;
            }
        }
        //dp[i]:s前i个字符是s[0...i-1]最少可以划分为几个回文串
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (i = 1; i <= s.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
            //从0到（i-1）遍历，更新dp数组
            for (j = 0; j < i; j++) {
                //s[j..i-1]是回文串
                if (A[j][i - 1]) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[s.length()] - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution132().minCut("danaranad"));
    }
}
