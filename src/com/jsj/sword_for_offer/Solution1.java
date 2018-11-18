package com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {
    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (doFind(target, array[i])) return true;
        }
        return false;
    }

    public boolean doFind(int target, int[] subArray) {
        int low = 0;
        int high = subArray.length - 1;
        int now;
        int nowValue;
        while (low <= high) {
            now = (low + high) / 2;
            nowValue = subArray[now];
            if (target == nowValue) {
                return true;
            } else if (target < nowValue) {
                high = now - 1;
            } else {
                low = now + 1;
            }
        }
        return false;
    }
}
