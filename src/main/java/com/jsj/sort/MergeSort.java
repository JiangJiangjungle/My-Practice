package com.jsj.sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] num) {
        return doMergeSort(num, 0, num.length);
    }

    private static int[] doMergeSort(int[] num, int start, int end) {
        if (end - start <= 1) return num;
        if (start == end - 2) {
            if (num[start] > num[start + 1]) swap(num, start, start + 1);
            return num;
        }
        int partition = (start + end) / 2;
        doMergeSort(num, start, partition);
        doMergeSort(num, partition, end);
        int[] tmp = Arrays.copyOfRange(num, start, end);
        for (int i = start, indexA = start, indexB = partition; i < end; i++) {
            if (indexB >= end || indexA < partition && tmp[indexA - start] < tmp[indexB - start]) {
                num[i] = tmp[indexA - start];
                indexA++;
            } else {
                num[i] = tmp[indexB - start];
                indexB++;
            }
        }
        return num;
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5,3})));
    }
}
