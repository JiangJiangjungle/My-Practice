package com.jsj.leetcode.dp;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * <p>
 * 思路：设立3个下标，从左到右逐个尝试（用record缓存中间结果）
 *
 * @author jsj
 * @date 2019-05-09
 */
public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] record = new int[s1.length() + 1][s2.length() + 1];
        return isInterleave(s1, 0, s2, 0, s3, 0, record);
    }

    private boolean isInterleave(String s1, int start1, String s2, int start2, String s3, int start3, int[][] record) {
        boolean interleave = false;
        if (start3 == s3.length()) {
            if (start1 == s1.length() && start2 == s2.length()) {
                interleave = true;
            }
        } else {
            if (start1 < s1.length() && s1.charAt(start1) == s3.charAt(start3)) {
                if (record[start1 + 1][start2] == 0) {
                    record[start1 + 1][start2] = isInterleave(s1, start1 + 1, s2, start2, s3, start3 + 1, record)
                            ? 1 : -1;
                }
                interleave = record[start1 + 1][start2] == 1;
            }
            if (!interleave && start2 < s2.length() && s2.charAt(start2) == s3.charAt(start3)) {
                if (record[start1][start2 + 1] == 0) {
                    record[start1][start2 + 1] = isInterleave(s1, start1, s2, start2 + 1, s3, start3 + 1, record)
                            ? 1 : -1;
                }
                interleave = record[start1][start2 + 1] == 1;
            }
        }
        record[start1][start2] = interleave ? 1 : -1;
        return interleave;
    }
}
