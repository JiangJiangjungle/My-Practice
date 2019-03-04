package com.jsj.leetcode.important;

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

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int[] bits = new int[32];
        int count = 0;
        for (; x > 0; x /= 10, count++) {
            bits[count] = x % 10;
        }
        for (int low = 0, high = count-1; low < high; low++, high--) {
            if (bits[low] != bits[high]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
