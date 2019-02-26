package com.jsj.sword_for_offer.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * <p>
 * 思路：利用hashMap计数，或者摩尔投票法
 */
public class Solution28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>(array.length / 2);
        int threshold = array.length / 2+1;
        for (int anArray : array) {
            if (map.containsKey(anArray)) {
                map.computeIfPresent(anArray, (integer, integer2) -> integer2 + 1);
            } else {
                map.put(anArray, 1);
            }
            if (threshold <= map.get(anArray)) return anArray;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution28().MoreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3}));
    }
}
