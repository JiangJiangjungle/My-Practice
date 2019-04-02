package com.jsj.leetcode.important;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-30
 * 题目描述：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(0));
        Deque<Integer> deque = new ArrayDeque<>();
        doSubsets(nums, 0, lists, deque);
        return lists;
    }

    private void doSubsets(int[] nums, int start, List<List<Integer>> lists, Deque<Integer> deque) {
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            deque.offerLast(nums[i]);
            lists.add(new ArrayList<>(deque));
            doSubsets(nums, i + 1, lists, deque);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution78().subsets(new int[]{1, 2, 3});
        if (null != list) {
            for (List<Integer> aList : list) {
                System.out.println(Arrays.toString(aList.toArray()));
            }
        }
    }
}
