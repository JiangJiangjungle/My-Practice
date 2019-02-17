package com.jsj.sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] num) {
        return doMergeSort(num, 0, num.length);
    }

    private static int[] doMergeSort(int[] num, int start, int end) {
        if (end - start <= 1) return num;
        int mid = (start + end) / 2;
        doMergeSort(num, start, mid);
        doMergeSort(num, mid, end);
        int[] tmp = Arrays.copyOfRange(num, start, end);
        for (int i = 0, j = mid - start, index = start; index < end; index++) {
            if (i == mid - start || j < tmp.length && tmp[i] > tmp[j]) {
                num[index] = tmp[j];
                j++;
            } else {
                num[index] = tmp[i];
                i++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5,4,2,9,3,5})));
    }
}
