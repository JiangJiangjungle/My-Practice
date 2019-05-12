package com.jsj.leetcode.dp;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 思路：将行数据看作是高度，按84题求最大矩形面积，进行到下一行并更新高度，再求最大矩形面积。
 *
 * @author jsj
 * @date 2019-05-05
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int val = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            val = Math.max(val, largestRectangleArea(heights, 0, heights.length - 1));
        }
        return val;
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
