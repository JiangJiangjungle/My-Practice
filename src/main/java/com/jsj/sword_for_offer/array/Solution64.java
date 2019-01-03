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
 *
 * 思路：最大堆
 */
public class Solution64 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length == 0 || size <= 0) return result;
        PriorityQueue<Integer> heap = new PriorityQueue<>(size, (o1, o2) -> o2 - o1);
        for (int i = 0; i < num.length; i++) {
            if (heap.size() == size) {
                heap.remove(num[i - size]);
            }
            heap.add(num[i]);
            if (heap.size() < size) {
                continue;
            }
            result.add(heap.peek());
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new Solution64().maxInWindows(new int[]{4, 3, 4, 2, 6, 2, 5, 1}, 3);
        if (null != list) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
