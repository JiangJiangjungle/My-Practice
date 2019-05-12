package com.jsj.leetcode.array;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-12-5
 * 题目描述：实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, nums.length);
                for (int j = i; j < nums.length; j++) {
                    if (nums[i - 1] < nums[j]) {
                        swap(nums, i - 1, j);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1};
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
