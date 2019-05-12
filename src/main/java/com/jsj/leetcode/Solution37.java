package com.jsj.leetcode;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-12-11
 * 题目描述：编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class Solution37 {

    public void solveSudoku(char[][] board) {
        doSolveSudoku(board);
    }

    public boolean doSolveSudoku(char[][] board) {
        int[] array = new int[board.length];
        int index;
        int range;
        int row;
        int column;
        boolean ok;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int y = 0; y < board.length; y++) {
                    if (board[i][y] == '.') {
                        continue;
                    }
                    index = board[i][y] - '1';
                    if (array[index] == 2) {
                        return false;
                    }
                    array[index] += 1;
                }
                for (int x = 0; x < board[0].length; x++) {
                    if (board[x][j] == '.') {
                        continue;
                    }
                    index = board[x][j] - '1';
                    if (array[index] >= 8) {
                        return false;
                    }
                    array[index] += 4;
                }
                range = (int) Math.sqrt(board.length);
                row = i / range * range;
                column = j / range * range;
                for (int x = row; x < range + row; x++) {
                    for (int y = column; y < range + column; y++) {
                        if (board[x][y] == '.') {
                            continue;
                        }
                        index = board[x][y] - '1';
                        if (array[index] >= 32) {
                            return false;
                        }
                        array[index] += 16;
                    }
                }
                int count = 0;
                for (int x = 0; x < array.length; x++) {
                    if (array[x] == 0) count++;
                }
                if (count == 1) {
                    for (int x = 0; x < array.length; x++) {
                        if (array[x] == 0) {
                            board[i][j] = (char) (x + '1');
                            if (!(ok = doSolveSudoku(board))) {
                                board[i][j] = '.';
                            }
                            return ok;
                        }
                    }
                }
                Arrays.fill(array, 0);
            }
        }
        //回溯
        if (check(board)) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') continue;
                getAvaliable(board, array, i, j);
                for (int x = 0; x < array.length; x++) {
                    if (array[x] > 0) continue;
                    board[i][j] = (char) (x + '1');
                    ok = doSolveSudoku(board);
                    if (ok) {
                        return true;
                    }
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') return false;
            }
        }
        return true;
    }

    private void getAvaliable(char[][] board, int[] array, int i, int j) {
        int index;
        int range;
        int row;
        int column;
        for (int y = 0; y < board.length; y++) {
            if (board[i][y] == '.') continue;
            index = board[i][y] - '1';
            array[index] += 1;
        }
        for (int x = 0; x < board[0].length; x++) {
            if (board[x][j] == '.') continue;
            index = board[x][j] - '1';
            array[index] += 4;
        }
        range = (int) Math.sqrt(board.length);
        row = i / range * range;
        column = j / range * range;
        for (int x = row; x < range + row; x++) {
            for (int y = column; y < range + column; y++) {
                if (board[x][y] == '.') continue;
                index = board[x][y] - '1';
                array[index] += 16;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        new Solution37().solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
