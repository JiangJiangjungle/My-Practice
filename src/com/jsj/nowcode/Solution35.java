package com.jsj.nowcode;

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

    private long doInverse(int[] array, int i, int j) {
        if (i == j) return 0;
        if (i + 1 == j) {
            if (array[i] > array[j]) {
                swap(array, i, j);
                return 1;
            } else return 0;
        }
        int half = (i + j) / 2;
        long count = 0L;
        count += doInverse(array, i, half) + doInverse(array, half + 1, j);
        int iNow = i;
        int jNow = half + 1;
        int[] temp = new int[j - i + 1];
        int tempNow = 0;
        while (iNow <= half && jNow <= j) {
            if (array[iNow] > array[jNow]) {
                count += half - iNow + 1;
                temp[tempNow++] = array[jNow++];
            } else {
                temp[tempNow++] = array[iNow++];
            }
        }
        while (iNow <= half) {
            temp[tempNow++] = array[iNow++];
        }
        while (jNow <= j) {
            temp[tempNow++] = array[jNow++];
        }

        System.arraycopy(temp, 0, array, i, temp.length);

        return count;
    }

    private void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
