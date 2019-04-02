package com.jsj.sword_for_offer.array;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 思路：参考归并排序，（冒泡排序计算复杂度太高）
 */
public class Solution35 {

    public int InversePairs(int[] array) {
        return doInverse(array, 0, array.length - 1);
    }

    private int doInverse(int[] array, int low, int high) {
        if (low >= high) return 0;
        if (low == high - 1) {
            if (array[low] > array[high]) {
                swap(array, low, high);
                return 1;
            }
            return 0;
        }
        int mid = (low + high) / 2;
        long val = doInverse(array, low, mid - 1) + doInverse(array, mid, high);
        int[] tmp = new int[high - low + 1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = array[low + i];
        }
        for (int i = low, x = 0, y = mid - low; i <= high; i++) {
            if (y > high - low || x < mid - low && tmp[x] <= tmp[y]) {
                array[i] = tmp[x];
                x++;
            } else {
                array[i] = tmp[y];
                val += mid - low - x;
                y++;
            }
        }
        return (int) (val % 1000000007);
    }

    private void swap(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(new Solution35().InversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }
}
