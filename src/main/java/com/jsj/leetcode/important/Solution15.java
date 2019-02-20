package com.jsj.leetcode.important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jsj
 * @since 2018-11-20
 * 题目描述：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list;
        Arrays.sort(nums);
        for (int index, i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                index = Arrays.binarySearch(nums, j + 1, nums.length, -1 * (nums[i] + nums[j]));
                if (index < 0) {
                    continue;
                }
                list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[index]);
                res.add(list);
                index = j;
                while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
                    index++;
                }
                j = index;
            }
        }
        return res;
    }
}
