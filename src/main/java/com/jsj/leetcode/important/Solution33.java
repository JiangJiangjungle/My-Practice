package com.jsj.leetcode.important;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-12-9
 * 题目描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 思路：每次分成两部分：有序数组+选择数组，对有序数组进行二分搜索，旋转数组继续拆分
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int low, int high) {
        int index = -1;
        if (low > high || low < 0 || high >= nums.length) {
            return index;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] >= nums[low]) {
            index = Arrays.binarySearch(nums, low, mid, target);
            if (index > -1) {
                return index;
            }
            return search(nums, target, mid+1, high);
        } else {
            index = Arrays.binarySearch(nums, mid + 1, high + 1, target);
            if (index > -1) {
                return index;
            }
            return search(nums, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution33().search(new int[]{2,3,4,7,1,2}, 4));
    }
}
