package com.jsj.leetcode.important;

/**
 * @author jsj
 * @since 2018-12-13
 * 题目描述：给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 思路：用char数组位移乘法
 */
public class Solution43 {


    public String multiply(String num1, String num2) {
        char[] chars = new char[num1.length() + num2.length()];
        for (int tmp, i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                chars[i + j + 1] += tmp;
            }
        }
        for (int tag = 0, i = chars.length - 1; i >= 0; i--) {
            chars[i] += tag;
            tag = chars[i] / 10;
            chars[i] %= 10;
            chars[i] += '0';
        }
        int offset = 0;
        for (; offset < chars.length && chars[offset] == '0'; offset++) {
        }
        return offset == chars.length ? "0" : String.valueOf(chars, offset, chars.length - offset);
    }

    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("0",
                "0"));
    }
}
