package com.jsj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jsj
 * @since 2018-12-18
 * 题目描述：n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>(n);
        char[][] matrixs = new char[n][n];
        for (int i = 0; i < matrixs[0].length; i++) {
            Arrays.fill(matrixs[i], '.');
        }
        doSolveNQueens(list, matrixs, 0);
        return list;
    }

    private void doSolveNQueens(List<List<String>> list, char[][] matrixs, int start) {
        if (start == matrixs.length) {
            List<String> aList = new ArrayList<>(matrixs.length);
            for (int i = 0; i < matrixs[0].length; i++) {
                aList.add(new String(matrixs[i]));
            }
            list.add(aList);
            return;
        }
        for (int i = 0; i < matrixs[0].length; i++) {
            if (check(matrixs, i, start)) {
                matrixs[i][start] = 'Q';
                doSolveNQueens(list, matrixs, start + 1);
                matrixs[i][start] = '.';
            }
        }
    }

    private boolean check(char[][] matrixs, int x, int y) {
        if (y == 0) return true;
        for (int i = 0; i < y; i++) {
            if (matrixs[x][i] == 'Q') return false;
        }
        if (x >= y) {
            for (int i = x - y, j = 0; j < y; i++, j++) {
                if (matrixs[i][j] == 'Q') return false;
            }
        } else {
            for (int i = 0, j = y - x; j < y; i++, j++) {
                if (matrixs[i][j] == 'Q') return false;
            }
        }
        if (matrixs.length - y - 1 >= x) {
            for (int i = y + x, j = 0; j < y; i--, j++) {
                if (matrixs[i][j] == 'Q') return false;
            }
        } else {
            for (int i = matrixs.length - 1, j = x + y - matrixs.length + 1; j < y; i--, j++) {
                if (matrixs[i][j] == 'Q') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> list = new Solution51().solveNQueens(4);
        if (list != null) {
            for (List<String> aList : list) {
                System.out.println(Arrays.toString(aList.toArray()));
            }
        }
    }
}
