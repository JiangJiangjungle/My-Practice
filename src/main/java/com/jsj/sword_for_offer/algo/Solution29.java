package com.jsj.sword_for_offer.algo;

import java.util.ArrayList;
import java.util.PriorityQueue;

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
        //用jdk提供的PriorityQueue实现堆
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            if (bigHeap.size() < k) {
                bigHeap.add(input[i]);
            } else if (input[i] < bigHeap.peek()) {
                bigHeap.poll();
                bigHeap.add(input[i]);
            }
        }
        result.addAll(bigHeap);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> r = new Solution29().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 8);
        if (r != null) {
            for (Integer i : r) {
                System.out.println(i);
            }
        }
    }
}
