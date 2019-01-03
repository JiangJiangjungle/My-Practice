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
        long count = doInverse(array, 0, array.length - 1);
        return (int) (count % 1000000007);
    }

    private long doInverse(int[] array, int start, int end) {
        if (start == end) return 0;
        if (start + 1 == end) {
            if (array[start] > array[end]) {
                swap(array, start, end);
                return 1;
            } else return 0;
        }
        int mid = (start + end) / 2;
        long count = 0L;
        count += doInverse(array, start, mid) + doInverse(array, mid + 1, end);
        int iNow = start;
        int jNow = mid + 1;
        int[] temp = new int[end - start + 1];
        int tempNow = 0;
        while (iNow <= mid && jNow <= end) {
            if (array[iNow] > array[jNow]) {
                count += mid - iNow + 1;
                temp[tempNow++] = array[jNow++];
            } else {
                temp[tempNow++] = array[iNow++];
            }
        }
        while (iNow <= mid) {
            temp[tempNow++] = array[iNow++];
        }
        while (jNow <= end) {
            temp[tempNow++] = array[jNow++];
        }

        System.arraycopy(temp, 0, array, start, temp.length);

        return count;
    }

    private void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static void main(String[] args) {
        System.out.println(new Solution35().InversePairs(new int[]{1, 2, 3, 4, 0, 2}));
    }
}
