package com.jsj.sword_for_offer.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {

    public void reOrderArray(int[] array) {
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                queue1.add(array[i]);
            } else {
                queue2.add(array[i]);
            }
        }
        for (int low = 0, high = queue1.size(); queue1.size() > 0 || queue2.size() > 0; low++, high++) {
            if (queue1.size() > 0) {
                array[low] = queue1.poll();
            }
            if (queue2.size() > 0) {
                array[high] = queue2.poll();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution13().reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
