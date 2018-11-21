package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-11-20
 * 题目描述：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 10) {
            return x >= 0;
        }
        int bits = 0;
        for (int copy = x; copy != 0; bits++) {
            copy = copy / 10;
        }
        int a;
        byte[] temp = new byte[bits / 2];
        for (int i = 0; x != 0; x = x / 10, i++) {
            a = x % 10;
            if (i < bits / 2) {
                temp[i] = (byte) a;
                continue;
            }
            if (i == bits / 2 && 1 == (bits & 1)) {
                continue;
            }
            if ((byte) a != temp[bits - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
