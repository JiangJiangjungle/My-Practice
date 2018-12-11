package com.jsj.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static int[] sort(int[] num) {
        if (num == null || num.length == 0) return num;
        PriorityQueue<Integer> heap = new PriorityQueue<>(num.length, (o1, o2) -> o1 - o2);
        for (int i = 0; i < num.length; i++) {
            heap.add(num[i]);
        }
        for (int i = 0; i < num.length; i++) {
            num[i] = heap.poll();
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(HeapSort.sort(new int[]{})));
    }
}
