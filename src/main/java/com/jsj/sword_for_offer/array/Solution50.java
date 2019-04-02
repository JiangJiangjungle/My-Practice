package com.jsj.sword_for_offer.array;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * <p>
 * 思路：因为数组长度为N，且数值范围在0~N-1，所以直接拿值当下标,在对应下标的值+N，若重复找到下标就会发现值已经大于N了
 */
public class Solution50 {
    /**
     * @param numbers     数组
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        boolean duplicated = false;
        if (length == 0) return duplicated;
        for (int i = 0, index, val; i < length; i++) {
            index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            val = numbers[index];
            if (val >= length) {
                duplicated = true;
                duplication[0] = val - length;
                break;
            }
            numbers[index] += length;
        }
        return duplicated;
    }
}
