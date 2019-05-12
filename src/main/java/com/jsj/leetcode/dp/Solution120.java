package com.jsj.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * |     [2],
 * |    [3,4],
 * |   [6,5,7],
 * |  [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 思路：f(i,j)=num[i][j]+min{f(i+1,j),f(i+1,j+1)};
 * 字典可以基于长度为n的一维数组，更新范围为0-i；
 *
 * @author jsj
 * @date 2019-05-12
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] record = new int[triangle.size()];
        List<Integer> aList;
        for (int i = triangle.size() - 1; i >= 0; i--) {
            aList = triangle.get(i);
            for (int j = 0; j < aList.size(); j++) {
                if (i != triangle.size() - 1) {
                    record[j] = Math.min(record[j], record[j + 1]);
                }
                record[j] += aList.get(j);
            }
        }
        return record[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(new Integer[]{2}));
        triangle.add(Arrays.asList(new Integer[]{3, 4}));
        triangle.add(Arrays.asList(new Integer[]{6, 5, 7}));
        triangle.add(Arrays.asList(new Integer[]{4, 1, 8, 3}));
        System.out.println(new Solution120().minimumTotal(triangle));
    }
}
