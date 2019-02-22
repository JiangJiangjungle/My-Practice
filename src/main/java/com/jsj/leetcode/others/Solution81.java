package com.jsj.leetcode.others;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-12-31
 * 题目描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        boolean found;
        for (int mid; left <= right; ) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] < nums[right]) {
                return Arrays.binarySearch(nums, left, right + 1, target) >= 0;
            } else if (target == nums[left] || target == nums[right]) {
                return true;
            } else if (target > nums[left]) {
                if (nums[mid] < target) {
                    left++;
                    continue;
                }
                found = Arrays.binarySearch(nums, left, mid, target) >= 0;
            } else {
                if (nums[mid] > target) {
                    left++;
                    continue;
                }
                found = Arrays.binarySearch(nums, mid, right + 1, target) >= 0;
            }
            if (found) return true;
            left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution81().search(new int[]{3, 1, 1}, 2));
    }
}
