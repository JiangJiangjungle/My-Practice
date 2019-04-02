package com.jsj.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆排序的实现
 *
 * @author jsj
 * @date 2019-01-15
 */
public class HeapSort {

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        //整理成大顶堆
        buildMaxHeap(arr);
        //交换堆顶元素与末尾元素，调整堆结构(采用下沉法)
        for (int i = arr.length - 2; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    /**
     * 构造出大顶堆
     *
     * @param arr
     */

    public static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length - 1);
        }
    }

    /**
     * 采用下沉法从index开始调整大顶堆（建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i
     * @param end
     */
    private static void adjustHeap(int[] arr, int i, int end) {
        int num = arr[i];
        for (int j = 2 * i + 1; j <= end; j = 2 * j + 1) {
            if (j < end && arr[j + 1] > arr[j]) {
                j++;
            }
            if (num < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = num;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(HeapSort.sort(new int[]{4, 6, 8, 5, 9})));
    }
}
