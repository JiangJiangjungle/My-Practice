package com.jsj.company.icbc;

import java.util.Scanner;

/**
 * 给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入比特币前卖出。
 * <p>
 * <p>
 * 输入描述:
 * 正整数数组，为以空格分隔的n个正整数
 * <p>
 * 输出描述:
 * 最大利润
 * <p>
 * 输入例子1:
 * 7 1 5 3 6 4
 * <p>
 * 输出例子1:
 * 5
 */
public class Solution2 {

    public static int maxProft(String[] nums) {
        int max=Integer.MIN_VALUE;
        int lastMax = Integer.valueOf(nums[nums.length - 1]);
        for (int i = nums.length - 2,val,tmp; i >= 0; i--) {
            lastMax = Math.max(Integer.valueOf(nums[i+1]),lastMax);
            val = lastMax-Integer.valueOf(nums[i]);
            if (val>max){
                max = val;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] nums = str.split(" ");
            System.out.println(maxProft(nums));
        }
    }
}
