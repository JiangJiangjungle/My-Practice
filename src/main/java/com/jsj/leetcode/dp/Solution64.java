package com.jsj.leetcode.dp;

/**
 * @author jsj
 * @since 2018-12-20
 * 题目描述：给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int[][] record = new int[grid.length][grid[0].length];
        return doMinPathSum(grid, 0, 0, record);
    }

    private int doMinPathSum(int[][] grid, int nowX, int nowY, int[][] record) {
        if (nowX == grid.length - 1 && nowY == grid[0].length - 1) return grid[grid.length - 1][grid[0].length - 1];
        if (record[nowX][nowY] != 0) return record[nowX][nowY];
        int value;
        if (nowX < grid.length - 1 && nowY < grid[0].length - 1) {
            value = Math.min(doMinPathSum(grid, nowX + 1, nowY, record), doMinPathSum(grid, nowX, nowY + 1, record));
        } else if (nowX < grid.length - 1) {
            value = doMinPathSum(grid, nowX + 1, nowY, record);
        } else {
            value = doMinPathSum(grid, nowX, nowY + 1, record);
        }
        record[nowX][nowY] = grid[nowX][nowY] + value;
        return record[nowX][nowY];
    }
}
