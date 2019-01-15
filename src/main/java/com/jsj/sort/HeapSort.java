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

    public static int[] sort(int[] array) {
        if (array == null || array.length == 0) return array;
        for (int i = array.length; i > 1; i--) {
            //整理成大顶堆
            array = adjustHeap(array, i, true);
            //将堆顶元素和堆底元素交换，即得到当前最大元素正确的排序位置
            swap(array, 0, i - 1);
        }
        return array;
    }

    /**
     * 构建堆：将array看成完全二叉树的顺序存储结构,自最后一个非叶子节点开始往前逐步调整树形结构
     *
     * @param array
     * @param end   边界
     * @param max   是否大顶堆
     * @return
     */
    private static int[] adjustHeap(int[] array, int end, boolean max) {
        //从最后一个非叶子节点array.length/2-1开始，直到根节点0，反复调整堆
        for (int i = end / 2 - 1; i >= 0; i--) {
            adjustNode(array, i, end, max);
        }
        return array;
    }

    /**
     * 调整位置为start的节点与其子女节点
     *
     * @param array
     * @param start 节点位置
     * @param end   边界
     * @param max   是否大顶堆
     */
    private static void adjustNode(int[] array, int start, int end, boolean max) {
        int index = 2 * start + 1;
        int right = index + 1;
        boolean needSwap;
        if (right < end) {
            needSwap = max && array[right] > array[index] || !max && array[right] < array[index];
            if (needSwap) {
                index = right;
            }
        }
        needSwap = max && array[index] > array[start] || !max && array[index] < array[start];
        if (needSwap) {
            swap(array, start, index);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(HeapSort.sort(new int[]{5, 4, 7, 8, 9, 1, 6, 2, 3})));
    }
}
