package com.jsj.leetcode;

import java.util.Arrays;

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
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        char[] res = new char[num1.length() + num2.length()];
        char[] tmps = new char[num1.length() + 1];
        Arrays.fill(res, '0');
        Arrays.fill(tmps, '0');
        int bit1;
        for (int j = 0; j < num2.length(); j++) {
            bit1 = num2.charAt(num2.length() - 1 - j) - '0';
            multiply(tmps, num1, bit1);
            addToArray(res, tmps, j);
        }
        int lastIndex = 0;
        for (; lastIndex < res.length; lastIndex++) {
            if (res[lastIndex] != '0') break;
        }
        if (lastIndex == res.length && res[lastIndex - 1] == '0') return "0";
        return new String(res, lastIndex, res.length - lastIndex);
    }

    private void multiply(char[] tmps, String num1, int bit) {
        int now;
        int high = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            now = bit * (num1.charAt(i) - '0');
            if (high > 0) {
                now += high;
            }
            if (now >= 10) {
                high = now / 10;
                now %= 10;
            } else {
                high = 0;
            }
            tmps[i + 1] = (char) (now + '0');
            if (i == 0) {
                tmps[0] = high > 0 ? (char) (high + '0') : '0';
            }
        }
    }

    private void addToArray(char[] res, char[] tmps, int offset) {
        int now;
        boolean tag = false;
        offset = res.length - offset - 1;
        int count = tmps.length - 1;
        while (count >= 0) {
            now = tmps[count] + res[offset] - '0' - '0';
            count--;
            if (tag) {
                now++;
            }
            if (now >= 10) {
                tag = true;
                now -= 10;
            } else {
                tag = false;
            }
            res[offset] = (char) (now + '0');
            offset--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("237",
                "284"));
    }
}
