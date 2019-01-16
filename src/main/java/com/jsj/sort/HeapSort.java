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
        //整理成大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        //交换堆顶元素与末尾元素，调整堆结构
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
        return array;
    }

    /**
     * 从index开始调整大顶堆（建立在大顶堆已构建的基础上）
     *
     * @param array
     * @param index  节点位置
     * @param length 边界
     */
    private static void adjustHeap(int[] array, int index, int length) {
        //先取出当前元素i
        int temp = array[index];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = index * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (array[k] > temp) {
                array[index] = array[k];
                index = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        array[index] = temp;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(HeapSort.sort(new int[]{4, 6, 8, 5, 9})));
    }
}
