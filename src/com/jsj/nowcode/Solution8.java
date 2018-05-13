package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution8 {
    public int JumpFloor(int target) {
        if (target <= 2) return target;
        int i = 2;
        int last = 2;
        int lastOfLast = 1;
        int temp;
        while (i < target) {
            temp = last + lastOfLast;
            lastOfLast = last;
            last = temp;
            i++;
        }
        return last;
    }
}
