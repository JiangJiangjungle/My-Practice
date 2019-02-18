package com.jsj.sort;

import java.util.*;

public class FastSort {

    public static int[] sort2(int[] num) {
        int[] array = new int[1000];
        int i = 0;
        int low = 0, high = num.length - 1;
        array[i++] = low;
        array[i++] = high;
        for (; i > 0; ) {
            high = array[--i];
            low = array[--i];
            int mid = partition(num, low, high);
            if (mid < high) {
                array[i++] = mid;
                array[i++] = high;
            }
            if (mid > low) {
                array[i++] = low;
                array[i++] = mid;
            }
        }
        return num;
    }

    public static int[] sort(int[] num) {
        return doSort(num, 0, num.length - 1);
    }

    private static int[] doSort(int[] num, int low, int high) {
        if (low < high) {
            int mid = partition(num, low, high);
            doSort(num, low, mid - 1);
            doSort(num, mid + 1, high);
        }
        return num;
    }

    private static int partition(int[] num, int low, int high) {
        int i = low, j = high;
        if (i >= j) return low;
        int partition = num[i];
        for (; i < j; ) {
            for (; i < j; j--) {
                if (num[j] < partition) {
                    swap(num, i, j);
                    break;
                }
            }
            for (; i < j; i++) {
                if (num[i] > partition) {
                    swap(num, i, j);
                    break;
                }
            }
        }
        return i;
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort2(new int[]{6})));
    }
}
