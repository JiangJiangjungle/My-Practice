package com.jsj.leetcode.array;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 思路：先找到高度最小值，再以最小值下标为边界进行左右递归
 *
 * @author jsj
 * @date 2019-05-05
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights, int start, int end) {
        if (start == end) {
            return heights[start];
        }
        int indexMin = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[indexMin]) {
                indexMin = i;
            }
        }
        int val = (end - start + 1) * heights[indexMin];
        if (start < indexMin) {
            val = Math.max(val, largestRectangleArea(heights, start, indexMin - 1));
        }
        if (indexMin < end) {
            val = Math.max(val, largestRectangleArea(heights, indexMin + 1, end));
        }
        return val;
    }
}
