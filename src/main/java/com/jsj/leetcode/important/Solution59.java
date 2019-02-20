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
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 0;
        int value = 0;
        int bound;
        while (count <= (n - 1) / 2) {
            bound = n - 1 - count;
            if (count == bound) {
                value++;
                matrix[count][count] = value;
                break;
            }
            for (int i = count; i < bound; i++) {
                value++;
                matrix[count][i] = value;
            }
            for (int i = count; i < bound; i++) {
                value++;
                matrix[i][bound] = value;
            }
            for (int i = count; i < bound; i++) {
                value++;
                matrix[bound][bound - i + count] = value;
            }
            for (int i = count; i < bound; i++) {
                value++;
                matrix[bound - i + count][count] = value;
            }
            count++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new Solution59().generateMatrix(5);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
