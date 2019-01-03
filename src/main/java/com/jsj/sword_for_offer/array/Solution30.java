package com.jsj.sword_for_offer.array;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：计算连续子向量的最大和。
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。(子向量的长度至少是1)
 * <p>
 * 思路：查询从该数开始的最大和，若count<0则归零
 */
public class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxValue = array[0];
        int count = 0;
        for (int num : array) {
            count += num;
            maxValue = count > maxValue ? count : maxValue;
            if (count < 0) {
                count = 0;
            }
        }
        return maxValue;
    }
}
