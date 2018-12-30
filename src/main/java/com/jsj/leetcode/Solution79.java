package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-30
 * 题目描述：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] records = new boolean[board.length][board[0].length];
        boolean existed = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && doExist(board, i, j, records, word, 0)) {
                    return true;
                }
            }
        }
        return existed;
    }

    private boolean doExist(char[][] board, int x, int y, boolean[][] records, String word, int start) {
        if (start >= word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        boolean existed = false;
        if (!records[x][y] && board[x][y] == word.charAt(start)) {
            records[x][y] = true;
            existed = doExist(board, x + 1, y, records, word, start + 1)
                    || doExist(board, x - 1, y, records, word, start + 1)
                    || doExist(board, x, y - 1, records, word, start + 1)
                    || doExist(board, x, y + 1, records, word, start + 1);
            records[x][y] = false;
        }
        return existed;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A'}
        };
        System.out.println(new Solution79().exist(board, "A"));
    }
}
