package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 思路：化为char数组后，进行位运算
 */
public class Solution48 {
    public int Add(int num1,int num2) {
        char[] chars1 = Integer.toBinaryString(num1).toCharArray();
        char[] chars2 = Integer.toBinaryString(num2).toCharArray();

        int result = 0;
        boolean tag = false;
        for (int i = 0; i < 32; i++) {
            if (i < chars1.length && i < chars2.length) {
                if (chars1[chars1.length - 1 - i] == '1' && chars2[chars2.length - 1 - i] == '1') {
                    if (tag) {
                        result += 1 << i;
                    }
                    tag = true;
                } else if ((chars1[chars1.length - 1 - i] == '0' && chars2[chars2.length - 1 - i] == '1') ||
                        (chars1[chars1.length - 1 - i] == '1' && chars2[chars2.length - 1 - i] == '0')) {
                    if (!tag) {
                        result += 1 << i;
                    }
                } else if (tag) {
                    result += 1 << i;
                    tag = false;
                }
            } else if (i < chars1.length) {
                if (tag) {
                    if (chars1[chars1.length - 1 - i] == '0') {
                        result += 1 << i;
                        tag = false;
                    }
                } else if (chars1[chars1.length - 1 - i] == '1') {
                    result += 1 << i;
                }
            } else if (i < chars2.length) {
                if (tag) {
                    if (chars2[chars2.length - 1 - i] == '0') {
                        result += 1 << i;
                        tag = false;
                    }
                } else if (chars2[chars2.length - 1 - i] == '1') {
                    result += 1 << i;
                }
            } else {
                if (tag) {
                    result += 1 << i;
                }
                break;
            }
        }
        return result;
    }
}
