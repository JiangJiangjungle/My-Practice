package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-9
 * 题目描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (null == nums || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        for (; left <= right; ) {
            mid = (left + right) / 2;
            if (target == nums[mid]) return mid;
            if (left + 1 >= right && nums[right] != target) {
                if (left == right) {
                    return target > nums[mid] ? right + 1 : mid;
                } else {
                    if (target < nums[mid]) {
                        return mid;
                    } else {
                        return target < nums[right] ? right : right + 1;
                    }
                }
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution35().searchInsert(new int[]{1, 3}, 3));
    }
}
