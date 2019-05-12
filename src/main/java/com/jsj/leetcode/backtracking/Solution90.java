package com.jsj.leetcode.backtracking;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * 思路：利用全组合思想，同时同一层递归中剔除相同的元素
 *
 * @author jsj
 * @date 2019-05-06
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        Deque<Integer> deque = new ArrayDeque<>();
        subsetsWithDup(nums, 0, deque, list);
        return list;
    }

    private void subsetsWithDup(int[] nums, int start, Deque<Integer> deque, List<List<Integer>> list) {
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //剔除相同元素
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            deque.offerLast(nums[i]);
            list.add(new ArrayList<>(deque));
            subsetsWithDup(nums, i + 1, deque, list);
            deque.pollLast();
        }
    }
}
