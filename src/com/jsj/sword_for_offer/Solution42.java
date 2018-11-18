package com.jsj.sword_for_offer;

import java.util.ArrayList;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述：对应每个测试案例，输出两个数，小的先输出。
 */
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int low = 0;
        int high = array.length - 1;
        int v;
        ArrayList<Integer> result = new ArrayList<>();
        while (low < high) {
            v = array[low] + array[high];
            if (v == sum) {
                result.add(array[low]);
                result.add(array[high]);
                break;
            } else if (v > sum) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }
}
