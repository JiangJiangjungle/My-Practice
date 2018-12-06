package com.jsj.sword_for_offer.array;

import java.util.ArrayList;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Solution64 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length == 0 || size <= 0) return result;
        int max = num[0];
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (i < size) {
                if (max < num[i]) {
                    max = num[i];
                    index = i;
                }
                if (i == size - 1) {
                    result.add(max);
                }
            } else {
                if (num[i] > max || i - size >= index) {
                    if (num[i] > max) {
                        max = num[i];
                        index = i;
                    } else {
                        int[] maxPos = findMax(num, i - size + 1, i);
                        max = maxPos[0];
                        index = maxPos[1];
                    }
                }
                result.add(max);
            }
        }
        return result;
    }

    private int[] findMax(int[] num, int i, int j) {
        int[] result = new int[2];
        result[0] = num[i];
        result[1] = i;
        for (int x = i + 1; x <= j; x++) {
            if (num[x] > result[0]) {
                result[0] = num[x];
                result[1] = x;
            }
        }
        return result;
    }
}
