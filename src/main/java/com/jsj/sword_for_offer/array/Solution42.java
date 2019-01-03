package com.jsj.sword_for_offer.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述：对应每个测试案例，输出两个数，小的先输出。
 */
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        Set<Integer> record = new HashSet<>(array.length);
        for (int i = 0; i < array.length; i++) {
            record.add(array[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(2);
        for (int i = 0, another; i < array.length / 2; i++) {
            another = sum - array[i];
            if (record.contains(another)) {
                list.add(array[i]);
                list.add(another);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new Solution42().FindNumbersWithSum(new int[]{1,2,4,7,11,15},15);
    }
}
