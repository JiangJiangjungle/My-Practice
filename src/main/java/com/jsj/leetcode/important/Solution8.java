package com.jsj.leetcode.important;

/**
 * @author jsj
 * @since 2018-11-20
 * 题目描述：请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 */
public class Solution8 {
    public int myAtoi(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        boolean started = false;
        boolean metZero = false;
        int sigIndex = -1;
        int start = 0;
        int end = str.length();
        char now;
        for (int i = 0; i < str.length(); i++) {
            now = str.charAt(i);
            if (now >= '0' && now <= '9') {
                if (started && (i - start > 11)) {
                    end = i;
                    break;
                }
                if (started) {
                    continue;
                }
                if (now == '0') {
                    metZero = true;
                } else {
                    start = i;
                    started = true;
                }
                continue;
            } else if (started) {
                end = i;
                break;
            } else if (now == ' ' || now == '-' || now == '+') {
                if (!metZero && sigIndex == -1) {
                    if (now == '-' || now == '+') {
                        sigIndex = i;
                    }
                    continue;
                }
            }
            return 0;
        }
        if (!started) {
            return 0;
        }
        String res = "";
        if (sigIndex != -1) {
            res += str.charAt(sigIndex);
        }
        res += str.substring(start, end);
        if ("-".equals(res) || "+".equals(res)) {
            return 0;
        }
        long r = Long.parseLong(res);
        if (r > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (r < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) r;
    }
}
