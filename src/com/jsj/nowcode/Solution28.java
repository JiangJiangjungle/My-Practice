package com.jsj.nowcode;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * <p>
 * 思路：排序后利用二分查找，找到数组中间对应的数的最小位置和最大位置，判断是否大于一半
 */
public class Solution28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null) return 0;
        if (array.length == 1) return array[0];
        Arrays.sort(array);

        int half = array.length / 2;
        int temp = array[half];
        int low = 0;
        int high = half;
        int min = half;
        int max = half;

        int now;
        int nowValue;
        while (low <= high) {
            now = (low + high) / 2;
            nowValue = array[now];
            if (nowValue == temp) {
                if (now == 0) {
                    min = now;
                    break;
                }
                if (array[now - 1] != temp) {
                    min = now;
                    break;
                }
                high = now - 1;
            } else {
                if (array[now + 1] == temp) {
                    min = now + 1;
                    break;
                }
                low = now + 1;
            }
        }
        low = half;
        high = array.length - 1;
        while (low <= high) {
            now = (low + high) / 2;
            nowValue = array[now];
            if (nowValue == temp) {
                if (now == array.length - 1) {
                    max = now;
                    break;
                }
                if (array[now + 1] != temp) {
                    max = now;
                    break;
                }
                low = now + 1;
            } else {
                if (array[now - 1] == temp) {
                    max = now - 1;
                    break;
                }
                high = now - 1;
            }
        }
        if ((max - min) >= half) {
            return array[half];
        } else {
            return 0;
        }
    }
}
