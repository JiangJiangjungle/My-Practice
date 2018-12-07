package com.jsj.sort;

import java.util.Arrays;

public class ShellSort {
    public static int[] sort(int[] num) {
        int gap = num.length / 2;
        while (gap > 0) {
            doGapSort(num, gap);
            gap /= 2;
        }
        return num;
    }

    private static void doGapSort(int[] num, int gap) {
        for (int i = 0, now; i < gap; i++) {
            now = i + gap;
            while (now < num.length) {
                for (int j = i; j < num.length; j = j + gap) {
                    if (num[now] < num[j]) {
                        insert(num, j, now, gap);
                        break;
                    }
                }
                now += gap;
            }
        }
    }

    private static void insert(int[] num, int insertTo, int indexB, int gap) {
        for (int i = insertTo, temp; i < indexB; i = i + gap) {
            temp = num[i];
            num[i] = num[indexB];
            num[indexB] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 3, 2})));
    }
}
