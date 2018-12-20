package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-20
 * 题目描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] record = new int[m][n];
        return doUniquePaths(m, n, 0, 0, record);
    }

    private int doUniquePaths(int m, int n, int nowX, int nowY, int[][] record) {
        if (nowX >= m || nowY >= n) return 0;
        if (record[nowX][nowY] != 0) return record[nowX][nowY];
        if (nowX == m - 1 && nowY == n - 1) return 1;
        int value = 0;
        if (nowX < m - 1) {
            value += doUniquePaths(m, n, nowX + 1, nowY, record);
        }
        if (nowY < n - 1) {
            value += doUniquePaths(m, n, nowX, nowY + 1, record);
        }
        record[nowX][nowY]= value;
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths(2, 3));
    }
}
