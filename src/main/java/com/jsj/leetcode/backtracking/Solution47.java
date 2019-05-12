package com.jsj.leetcode.backtracking;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-18
 * 题目描述：给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        doPermuteUnique(nums, 0, list);
        return list;
    }

    private void doPermuteUnique(int[] nums, int start, List<List<Integer>> list) {
        if (start == nums.length - 1) {
            List<Integer> aList = new ArrayList<>(nums.length);
            for (int num : nums) {
                aList.add(num);
            }
            list.add(aList);
        }
        Set<Integer> repeatSet = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (i > start && repeatSet.contains(nums[i])) continue;
            swap(nums, i, start);
            doPermuteUnique(nums, start + 1, list);
            swap(nums, i, start);
            repeatSet.add(nums[i]);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution47().permuteUnique(new int[]{0, 0, 0, 1, 9});
        for (List<Integer> aList : list) {
            System.out.println(Arrays.toString(aList.toArray()));
        }
    }
}
