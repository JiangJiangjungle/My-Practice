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

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int low = 0, high = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int x = i - 1, y = i + 1; x >= 0 && y < s.length(); x--, y++) {
                if (s.charAt(x) != s.charAt(y)) {
                    break;
                }
                if (y - x > high - low) {
                    high = y;
                    low = x;
                }
            }
            for (int x = i, y = i + 1; x >= 0 && y < s.length(); x--, y++) {
                if (s.charAt(x) != s.charAt(y)) {
                    break;
                }
                if (y - x > high - low) {
                    high = y;
                    low = x;
                }
            }
        }
        return s.substring(low, high + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("aead"));
    }
}
