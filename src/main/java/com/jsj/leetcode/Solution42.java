package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-13
 * 题目描述：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution42 {

    public int trap(int[] height) {
        boolean prefixFlag = false;
        int temp = 0;
        int sum = 0;
        int length = height.length;
        int i = 1;
        boolean flag = false;
        while (true) {
            prefixFlag = false;
            temp = 0;
            flag = false;
            for (int j = 0; j < length; j++) {
                if (height[j] >= i) {
                    flag = true;
                    prefixFlag = true;
                    sum += temp;
                    temp = 0;
                } else {
                    if (prefixFlag) {
                        temp++;
                    }
                }
            }
            if (!flag) {
                break;
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));
    }
}
