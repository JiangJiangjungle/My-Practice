package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-25
 * 题目描述：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        boolean tag = true;
        int[] newDigits = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = tag ? digits[i] + 1 : digits[i];
            newDigits[i + 1] = digits[i];
            if (newDigits[i + 1] < 10) {
                tag = false;
                continue;
            }
            newDigits[i + 1] = 0;
            digits[i] = 0;
            if (i == 0) {
                newDigits[i] = 1;
                return newDigits;
            }
            tag = true;
        }
        return digits;
    }
}
