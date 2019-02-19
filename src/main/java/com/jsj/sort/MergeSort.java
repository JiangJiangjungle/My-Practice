package com.jsj.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] arr) {
        doMergeSort(arr, 0, arr.length);
        return arr;
    }

    private static void doMergeSort(int[] arr, int start, int end) {
        if (start >= end - 1) return;
        int mid = (start + end) / 2;
        doMergeSort(arr, start, mid);
        doMergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start];
        for (int i = 0, j = start; i < tmp.length; i++, j++) {
            tmp[i] = arr[j];
        }
        for (int i = 0, j = mid - start, index = start; index < end; index++) {
            if (j == end - start || i < mid - start && tmp[i] < tmp[j]) {
                arr[index] = tmp[i];
                i++;
            } else {
                arr[index] = tmp[j];
                j++;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 4, 2, 9, 3, 5})));
    }
}
