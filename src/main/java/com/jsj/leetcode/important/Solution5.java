package com.jsj.leetcode.important;

/**
 * @author jsj
 * @since 2018-11-18
 * 题目描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 思路：中间扩展法，（xxxaxxx）或者（xxxxxx）形式
 */
public class Solution5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int index = 0; index < s.length(); index++) {
            for (int low = index, high = index; low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high); low--, high++) {
                if (high - low > end - start) {
                    start = low;
                    end = high;
                }
            }
            for (int low = index, high = index + 1; low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high); low--, high++) {
                if (high - low > end - start) {
                    start = low;
                    end = high;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("daead"));
    }
}
