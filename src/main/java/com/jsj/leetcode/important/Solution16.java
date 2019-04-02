package com.jsj.leetcode.important;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-11-21
 * 题目描述：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 思路：时间复杂度O(N^2)的方法，数组排序，第一个指针从0开始，每右移1格，开始循环：第二个指针从下一位开始右移，第三个指针从尾部左移，找和的最小值。
 */
public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int val = Integer.MAX_VALUE;
        for (int tmp, x = 0; x < nums.length - 2; x++) {
            for (int y = x + 1, z = nums.length - 1; y < z; ) {
                tmp = nums[x] + nums[y] + nums[z];
                if (Math.abs(tmp - target) < Math.abs(val - target)) {
                    val = tmp;
                    if (val == target) {
                        return val;
                    }
                }
                if (tmp > target) {
                    z--;
                }
                y++;
            }
        }
        return val;
    }
}
