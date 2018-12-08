package com.jsj.sort;

import java.util.Arrays;

public class FastSort {

    public static int[] sort(int[] num) {
        return doPartition(num, 0, num.length);
    }

    private static int[] doPartition(int[] num, int start, int end) {
        int i = start, j = end - 1;
        if (i >= j) return num;
        int partition = num[i];
        A:
        while (i < j) {
            while (num[j] >= partition) {
                j--;
                if (i == j) break A;
            }
            swap(num, i, j);
            while (i < j && num[i] <= partition) {
                i++;
                if (i == j) break A;
            }
            swap(num, i, j);
        }
        doPartition(num, start, i);
        doPartition(num, i + 1, end);
        return num;
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{6, 4, 6, 5})));
    }
}
