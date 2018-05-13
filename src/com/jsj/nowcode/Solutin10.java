package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solutin10 {
    public int RectCover(int target) {
        if (target <= 2) return target;
        int[] temp = new int[2];
        temp[0] = 1;
        temp[1] = 2;
        int i = 2;
        int a;
        while (i < target) {
            a = temp[1];
            temp[1] += temp[0];
            temp[0] = a;
            i++;
        }
        return temp[1];
    }
}
