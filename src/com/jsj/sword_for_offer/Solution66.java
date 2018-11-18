package com.jsj.sword_for_offer;

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
        boolean[] hasTraveled = new boolean[cols * rows];
        return doCount(threshold, rows, cols, hasTraveled, 0, 0);
    }

    private int doCount(int threshold, int rows, int cols, boolean[] hasTraveled, int nowRow, int nowCol) {
        if (nowRow < 0 || nowCol < 0 || nowRow >= rows || nowCol >= cols) return 0;
        if (!isLegal(nowRow, nowCol, threshold, cols) || hasTraveled[nowRow * cols + nowCol]) return 0;
        hasTraveled[nowRow * cols + nowCol] = true;
        return 1 + doCount(threshold, rows, cols, hasTraveled, nowRow - 1, nowCol)
                + doCount(threshold, rows, cols, hasTraveled, nowRow + 1, nowCol)
                + doCount(threshold, rows, cols, hasTraveled, nowRow, nowCol - 1)
                + doCount(threshold, rows, cols, hasTraveled, nowRow, nowCol + 1);
    }

    private boolean isLegal(int x, int y, int threshold, int cols) {
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
