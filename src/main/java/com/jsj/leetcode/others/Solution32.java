package com.jsj.leetcode.others;

/**
 * @author jsj
 * @since 2018-12-9
 * 题目描述：给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        return doGetlongestValidParentheses(s, 0, s.length());
    }

    public int doGetlongestValidParentheses(String s, int start, int end) {
        int left = start;
        int right = end - 1;
        for (; left < end && ')' == s.charAt(left); left++) {
        }
        for (; right >= start && '(' == s.charAt(right); right--) {
        }
        if (left > right) return 0;
        int count = 1;
        int length = 0;
        for (int i = left + 1; i <= right; i++) {
            count += s.charAt(i) == '(' ? 1 : -1;
            if (count == 0) {
                length = i - left + 1;
                continue;
            }
            if (count < 0) {
                return Math.max(length, doGetlongestValidParentheses(s, i + 1, right + 1));
            }

        }
        if (count == 0) return length;
        return Math.max(length, doGetlongestValidParentheses(s, left + 1, right + 1));
    }

    public static void main(String[] args) {
        System.out.println(new Solution32().longestValidParentheses("((()()(()((()"));
    }
}
