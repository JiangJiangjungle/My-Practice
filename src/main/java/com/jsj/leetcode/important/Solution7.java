package com.jsj.leetcode.important;

/**
 * @author jsj
 * @since 2018-11-20
 * 题目描述：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。如果反转后整数溢出那么就返回 0
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class Solution7 {

    public static int reverse(int x) {
        int tag = 1;
        if (x < 0) {
            tag = -1;
            x *= tag;
        }
        int val = 0;
        for (int tmp; x > 0; x = x / 10) {
            tmp = x % 10;
            val *= 10;
            val += tmp;
        }
        return tag * val;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1030));
    }
}
