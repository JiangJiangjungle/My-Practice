package com.jsj.sword_for_offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * <p>
 * 思路：维护一个大小为k的最大堆，当下一个数小于堆最大值，替换至堆顶并更新
 */
public class Solution29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k == 0) {
            return result;
        }
        int[] heap = new int[k];
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                heap[i] = input[i];
                if (i == k - 1) {
                    init(heap);
                }
            } else {
                if (input[i] < heap[0]) {
                    refresh(heap, input[i]);
                }
            }
        }
        Arrays.sort(heap);
        for (Integer i : heap) {
            result.add(i);
        }
        return result;
    }

    private void init(int[] array) {
        int n = array.length;
        int now;
        int left;
        int right;

        for (int i = n / 2 - 1; i >= 0; i--) {
            now = i;
            while ((now <= n / 2 - 1)) {
                left = 2 * (now + 1) - 1;
                if (now == n / 2 - 1 && n % 2 == 0) {
                    if (array[now] < array[left]) {
                        swap(array, now, left);
                    }
                    break;
                }
                right = left + 1;
                if (array[now] < array[left] || array[now] < array[right]) {

                    if (array[now] < array[left] && array[now] < array[right]) {
                        if (array[left] < array[right]) {
                            swap(array, now, right);
                            now = right;
                        } else {
                            swap(array, now, left);
                            now = left;
                        }
                    } else if (array[now] < array[left]) {
                        swap(array, now, left);
                        now = left;
                    } else {
                        swap(array, now, right);
                        now = right;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public void refresh(int[] array, int num) {
        array[0] = num;
        init(array);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
