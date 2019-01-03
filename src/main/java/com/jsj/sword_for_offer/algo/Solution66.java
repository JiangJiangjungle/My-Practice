package com.jsj.sword_for_offer.algo;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class Solution66 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] records = new boolean[rows][cols];
        return doCount(threshold, rows, cols, records, 0, 0);
    }

    private int doCount(int threshold, int rows, int cols, boolean[][] records, int x, int y) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || records[x][y] || !check(x, y, threshold)) return 0;
        records[x][y] = true;
        return 1 + doCount(threshold, rows, cols, records, x + 1, y)
                + doCount(threshold, rows, cols, records, x - 1, y)
                + doCount(threshold, rows, cols, records, x, y + 1)
                + doCount(threshold, rows, cols, records, x, y - 1);
    }

    private boolean check(int x, int y, int threshold) {
        int count = 0;

        while (x != 0) {
            count += x % 10;
            x = x / 10;
        }
        while (y != 0) {
            count += y % 10;
            y = y / 10;
        }
        return count <= threshold;
    }
}
