package com.jsj.leetcode.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jsj
 * @since 2018-11-18
 * 题目描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为gai目标值的 两个 整数。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> records = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            records.put(nums[i], i);
        }
        Integer index;
        int value;
        for (int i = 0; i < nums.length; i++) {
            value = target - nums[i];
            if ((index = records.get(value)) != null && index != i) {
                return new int[]{i, index};
            }
        }
        return null;
    }
}
