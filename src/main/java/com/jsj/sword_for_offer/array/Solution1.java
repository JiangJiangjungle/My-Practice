package com.jsj.sword_for_offer.array;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {
    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (Arrays.binarySearch(array[i],target)>=0) return true;
        }
        return false;
    }
}
