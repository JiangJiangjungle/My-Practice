package com.jsj.sword_for_offer.algo;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution10 {
    public int RectCover(int target) {
        if (target <= 2) return target;
        int count = 2;
        int fn_1 = 1;
        int fn = 2;
        int temp;
        while (count < target) {
            temp = fn;
            fn += fn_1;
            fn_1 = temp;
            count++;
        }
        return fn;
    }
}
