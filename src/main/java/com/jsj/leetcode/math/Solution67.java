package com.jsj.leetcode.math;

/**
 * @author jsj
 * @since 2018-12-25
 * 题目描述：给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        char[] chars = new char[Math.max(a.length(), b.length()) + 1];
        int tag = 0;
        for (int indexA = a.length() - 1, indexB = b.length() - 1, i = chars.length - 1; i > 0; i--) {
            if (indexA >= 0 && indexB >= 0) {
                chars[i] = (char) (a.charAt(indexA) + b.charAt(indexB) + tag - '0');
                indexA--;
                indexB--;
            } else if (indexA < 0) {
                chars[i] = (char) (b.charAt(indexB) + tag);
                indexB--;
            } else {
                chars[i] = (char) (a.charAt(indexA) + tag);
                indexA--;
            }
            if ('2' <= chars[i]) {
                chars[i] -= 2;
                if (i == 1) {
                    chars[0] = '1';
                    return new String(chars);
                }
                tag = 1;
            } else {
                tag = 0;
            }
        }
        return new String(chars, 1, chars.length - 1);
    }
}
