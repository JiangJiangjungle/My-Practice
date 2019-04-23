package com.jsj.leetcode.others;

/**
 * @author jsj
 * @since 2018-12-13
 * 题目描述：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 思路：寻找U型坑；从起点开始寻找>=起点高度的下标，若找到则将当前下标更新为起点，开始寻找下一个
 */
public class Solution42 {

    public int trap(int[] height) {
        return trap(height,0);
    }

    private int trap(int[] height, int start) {
        int val = 0;
        int secondHigh = -1;
        int low = start;
        for (int count = 0, now = low + 1; now < height.length; now++) {
            if (height[now] >= height[low]) {
                val += count;
                low = now;
                count = 0;
                secondHigh = -1;
                continue;
            }
            if (secondHigh == -1 || height[secondHigh] < height[now]) {
                secondHigh = now;
            }
            count += height[low] - height[now];
        }
        //未找到大于等于起点高度的下标就更新到第二高的下标
        if (secondHigh != -1) {
            for (int now = low + 1; now < secondHigh; now++) {
                val += height[secondHigh] - height[now];
            }
            //从secondHigh为起点重新进行统计
            val += trap(height, secondHigh);
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));
    }
}
