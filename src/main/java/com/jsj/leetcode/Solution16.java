package com.jsj.leetcode;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-11-21
 * 题目描述：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeNum = nums[0]+nums[1]+nums[2];
        int now;
        A:
        for (int x = 0; x < nums.length - 2; x++) {
            for (int i = x + 1, j = nums.length - 1; i < j; ) {
                now = nums[x] + nums[i] + nums[j];
                if (Math.abs(closeNum-target) >Math.abs(now-target) ) {
                    closeNum = now;
                    if (closeNum == target) {
                        break A;
                    }
                }
                if (now > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return closeNum;
    }
}
