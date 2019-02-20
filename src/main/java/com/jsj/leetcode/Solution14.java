package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-11-20
 * 题目描述：编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char now;
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = minLength > str.length() ? str.length() : minLength;
        }
        A:
        for (int x = 0; x < minLength; x++) {
            now = strs[0].charAt(x);
            for (int i = 1; i < strs.length; i++) {
                if (now != strs[i].charAt(x)) {
                    break A;
                }
            }
            sb.append(now);
        }
        return sb.toString();
    }
}
