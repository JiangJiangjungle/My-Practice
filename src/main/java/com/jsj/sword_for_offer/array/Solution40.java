package com.jsj.sword_for_offer.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Solution40 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Set<Integer> set = new HashSet<>();
        for (int anArray : array) {
            if (set.contains(anArray)) {
                set.remove(anArray);
            } else {
                set.add(anArray);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        num1[0] = iterator.next();
        num2[0] = iterator.next();
    }
}
