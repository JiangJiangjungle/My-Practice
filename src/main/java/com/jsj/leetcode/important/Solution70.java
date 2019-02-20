package com.jsj.leetcode.important;

/**
 * @author jsj
 * @since 2018-12-26
 * 题目描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int fn_1 = 2;
        int fn_2 = 1;
        int count = 0;
        for (int i = 3; i <= n; i++) {
            count = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(8));
    }
}
