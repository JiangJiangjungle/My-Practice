package com.jsj.leetcode.others;

/**
 * @author jsj
 * @since 2018-11-18
 * 题目描述：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R   G
 * E T O E S I I
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRGETOESIIEDHN"。
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int invert = 2 * numRows - 2;
        int start;
        for (int i = 0; i < numRows; i++) {
            start = i;
            while (start < s.length()) {
                sb.append(s.charAt(start));
                start += invert;
                if (i != 0 && i != numRows - 1 && (start - 2 * i) < s.length()) {
                    sb.append(s.charAt(start - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}
