package com.jsj.leetcode;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-18
 * 题目描述：给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>(nums.length);
        doPermute(nums, 0, list, stack);
        return list;
    }

    private void doPermute(int[] nums, int start, List<List<Integer>> list, Deque<Integer> stack) {
        if (stack.size() == nums.length) {
            List<Integer> aList = new ArrayList<>(stack);
            list.add(aList);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            stack.addLast(nums[start]);
            doPermute(nums, start + 1, list, stack);
            swap(nums, i, start);
            stack.pollLast();
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution46().permute(new int[]{});
        for (List<Integer> aList : list) {
            System.out.println(Arrays.toString(aList.toArray()));
        }
    }
}
