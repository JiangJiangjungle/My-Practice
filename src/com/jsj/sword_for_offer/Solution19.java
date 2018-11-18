package com.jsj.sword_for_offer;

import java.util.ArrayList;

/**
 * @author jsj
 * @since 2018-5-12
 *
 * 题目描述：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        //行终点
        int rowEnd = matrix.length - 1;
        //列终点
        int columnEnd = matrix[0].length - 1;
        //行起点
        int rowBegin = 0;
        //列起点
        int columnBegin = 0;
        int i;
        while (columnBegin <= columnEnd && rowBegin <= rowEnd) {
            i = columnBegin;
            while (i <= columnEnd) {
                result.add(matrix[rowBegin][i]);
                i++;
            }
            rowBegin++;
            i = rowBegin;
            while (i <= rowEnd && columnBegin <= columnEnd) {
                result.add(matrix[i][columnEnd]);
                i++;
            }
            columnEnd--;
            i = columnEnd;
            while (i >= columnBegin && rowBegin <= rowEnd) {
                result.add(matrix[rowEnd][i]);
                i--;
            }
            rowEnd--;
            i = rowEnd;
            while (i >= rowBegin && columnBegin <= columnEnd) {
                result.add(matrix[i][columnBegin]);
                i--;
            }
            columnBegin++;
        }
        return result;
    }
}
