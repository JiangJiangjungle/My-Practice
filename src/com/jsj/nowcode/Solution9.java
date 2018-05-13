package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution9 {
    public int JumpFloorII(int target) {
        int result = 1;
        while (--target > 0) {
            result = result << 1;
        }
        return result;
    }
}
