package main.java.com.jsj.sword_for_offer;

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
        boolean[] hasTraveled = new boolean[rows * cols];
        for (int i = 0; i < matrix.length; i++) {
            if (doHasPath(matrix, rows, cols, str, 0, i / cols, i % cols, hasTraveled)) {
                return true;
            }
        }
        return false;
    }

    private boolean doHasPath(char[] matrix, int rows, int cols, char[] str, int begin, int nowRow, int nowCol, boolean[] hasTraveled) {
        if (nowRow < 0 || nowCol < 0 || nowRow >= rows || nowCol >= cols) return false;
        if (hasTraveled[nowRow * cols + nowCol] || matrix[nowRow * cols + nowCol] != str[begin]) return false;
        if (begin == str.length - 1) return true;
        hasTraveled[nowRow * cols + nowCol] = true;
        boolean tag = doHasPath(matrix, rows, cols, str, begin + 1, nowRow - 1, nowCol, hasTraveled)
                || doHasPath(matrix, rows, cols, str, begin + 1, nowRow + 1, nowCol, hasTraveled)
                || doHasPath(matrix, rows, cols, str, begin + 1, nowRow, nowCol - 1, hasTraveled)
                || doHasPath(matrix, rows, cols, str, begin + 1, nowRow, nowCol + 1, hasTraveled);
        if (!tag) {
            hasTraveled[nowRow * cols + nowCol] = false;
            return false;
        }
        return true;
    }
}
