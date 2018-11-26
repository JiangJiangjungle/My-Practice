package com.jsj.sword_for_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {

    public void reOrderArray(int[] array) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int num;
        for (int anArray : array) {
            num = anArray;
            if (num % 2 == 0) {
                queue2.add(num);
            } else {
                queue1.add(num);
            }
        }
        int i = 0;
        while (!queue1.isEmpty()) {
            array[i] = queue1.remove();
            i++;
        }
        while (!queue2.isEmpty()) {
            array[i] = queue2.remove();
            i++;
        }
    }
}
