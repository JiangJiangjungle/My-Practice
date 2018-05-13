package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：计算连续子向量的最大和。
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。(子向量的长度至少是1)
 * <p>
 * 思路：遇到一个正数就查询从该数开始是否有最大和，若没有正数就输出最大的负数
 */
public class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = -1;
        int count;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count = getMax(array, i);
                if (count > max) {
                    max = count;
                }
            }
        }
        if (max == -1) {
            int nMax = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > nMax) {
                    nMax = array[i];
                }
            }
            max = nMax;
        }
        return max;
    }

    private int getMax(int[] array, int i) {
        int max = 0;
        int count = 0;
        for (int x = i; x < array.length; x++) {
            count += array[x];
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
