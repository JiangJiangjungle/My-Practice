package com.jsj.leetcode.important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jsj
 * @since 2018-12-19
 * 题目描述：给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return list;
        for (int boundX = matrix.length - 1, boundY = matrix[0].length - 1, count = 0; count <= boundX && count <= boundY; count++, boundX--, boundY--) {
            for (int i = count; i <= boundY; i++) {
                list.add(matrix[count][i]);
            }
            for (int i = count + 1; i <= boundX; i++) {
                list.add(matrix[i][boundY]);
            }
            for (int i = boundY - 1; count < boundX && i >= count; i--) {
                list.add(matrix[boundX][i]);
            }
            for (int i = boundX - 1; count < boundY && i > count; i--) {
                list.add(matrix[i][count]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1}};
        List<Integer> list = new Solution54().spiralOrder(matrix);
        if (list != null) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
