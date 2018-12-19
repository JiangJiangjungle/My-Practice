package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-18
 * 题目描述：n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class Solution52 {
    public int totalNQueens(int n) {
        int[][] matrixs = new int[n][n];
        return doTotalNQueens(matrixs, 0);
    }

    private int doTotalNQueens(int[][] matrixs, int start) {
        if (start == matrixs.length) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < matrixs[0].length; i++) {
            if (check(matrixs, i, start)) {
                matrixs[i][start] = 1;
                count += doTotalNQueens(matrixs, start + 1);
                matrixs[i][start] = 0;
            }
        }
        return count;
    }

    private boolean check(int[][] matrixs, int x, int y) {
        if (y == 0) return true;
        for (int i = 0; i < y; i++) {
            if (matrixs[x][i] == 1) return false;
        }
        if (x >= y) {
            for (int i = x - y, j = 0; j < y; i++, j++) {
                if (matrixs[i][j] == 1) return false;
            }
        } else {
            for (int i = 0, j = y - x; j < y; i++, j++) {
                if (matrixs[i][j] == 1) return false;
            }
        }
        if (matrixs.length - y - 1 >= x) {
            for (int i = y + x, j = 0; j < y; i--, j++) {
                if (matrixs[i][j] == 1) return false;
            }
        } else {
            for (int i = matrixs.length - 1, j = x + y - matrixs.length + 1; j < y; i--, j++) {
                if (matrixs[i][j] == 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution52().totalNQueens(5));
    }
}
