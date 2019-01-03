package com.jsj.sword_for_offer.algo;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Solution65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] records = new boolean[rows][cols];
        boolean had;
        for (int i = 0, x, y; i < matrix.length; i++) {
            if (str[0] != matrix[i]) {
                continue;
            }
            x = i / cols;
            y = i % cols;
            had = doHasPath(matrix, rows, cols, str, 0, x, y, records);
            if (had) return true;
        }
        return false;
    }

    private boolean doHasPath(char[] matrix, int rows, int cols, char[] str, int start, int x, int y, boolean[][] records) {
        if (start == str.length) return true;
        if (x == rows || y == cols || x < 0 || y < 0 || records[x][y] || matrix[x * cols + y] != str[start]) {
            return false;
        }
        records[x][y] = true;
        boolean had = doHasPath(matrix, rows, cols, str, start + 1, x + 1, y, records)
                || doHasPath(matrix, rows, cols, str, start + 1, x - 1, y, records)
                || doHasPath(matrix, rows, cols, str, start + 1, x, y + 1, records)
                || doHasPath(matrix, rows, cols, str, start + 1, x, y - 1, records);

        records[x][y] = false;
        return had;
    }
}
