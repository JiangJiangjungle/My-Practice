package com.jsj.sword_for_offer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * <p>
 * 思路：双指针法,时间复杂度O(n)
 */
public class Solution64 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0 || size > num.length) return list;
        //low作为下标始终指向当前窗口最大值
        for (int low = 0, high = 1; high < num.length; high++) {
            if (num[high] >= num[low]) {
                low = high;
            }
            //找到当前最大值，用low指针作为下标
            if (high - low == size) {
                low++;
                for (int i = low; i <= high; i++) {
                    if (num[i] >= num[low]) {
                        low = i;
                    }
                }
            }
            if (high >= size - 1) {
                list.add(num[low]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new Solution64().maxInWindows(new int[]{4, 3, 4, 2, 6, 2, 5, 1}, 3);
        if (null != list) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
