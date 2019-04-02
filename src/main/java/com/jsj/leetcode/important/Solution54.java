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
        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        for (int now = 0, endX = matrix.length - 1, endY = matrix[0].length - 1; now <= endX && now <= endY; endX--, endY--, now++) {
            for (int i = now; i <= endY; i++) {
                list.add(matrix[now][i]);
            }
            for (int i = now + 1; i < endX; i++) {
                list.add(matrix[i][endY]);
            }
            if (endX <= now) {
                continue;
            }
            for (int i = endY; i >= now; i--) {
                list.add(matrix[endX][i]);
            }
            if (endY <= now) {
                continue;
            }
            for (int i = endX - 1; i > now; i--) {
                list.add(matrix[i][now]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3},
                {2, 4}};
        List<Integer> list = new Solution54().spiralOrder(matrix);
        if (list != null) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
