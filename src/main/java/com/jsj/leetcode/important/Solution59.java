package com.jsj.leetcode.important;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-12-20
 * 题目描述：给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Solution59 {
    public int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int num=1;
        for (int boundX = matrix.length - 1, boundY = matrix[0].length - 1, count = 0; count <= boundX && count <= boundY; count++, boundX--, boundY--) {
            for (int i = count; i <= boundY; i++) {
                matrix[count][i] = num++;
            }
            for (int i = count + 1; i <= boundX; i++) {
                matrix[i][boundY] = num++;
            }
            for (int i = boundY - 1; count < boundX && i >= count; i--) {
                matrix[boundX][i] = num++;
            }
            for (int i = boundX - 1; count < boundY && i > count; i--) {
                matrix[i][count] = num++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new Solution59().generateMatrix2(5);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
