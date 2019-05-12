package com.jsj.leetcode.array;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-12-9
 * 题目描述：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0) return new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int mid;
        for (; left <= right; ) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                int start = left;
                for (int left2 = left, right2 = mid; left2 <= right2; ) {
                    start = (left2 + right2) / 2;
                    if (nums[start] == target) {
                        if (start == left || nums[start - 1] != target) {
                            break;
                        }
                        right2 = start - 1;
                    } else {
                        if (nums[start + 1] == target) {
                            start++;
                            break;
                        }
                        left2 = start + 1;
                    }
                }
                int end = right;
                for (int left2 = mid, right2 = right; left2 <= right2; ) {
                    end = (left2 + right2) / 2;
                    if (nums[end] == target) {
                        if (end == right || nums[end + 1] != target) {
                            break;
                        }
                        left2 = end + 1;
                    } else {
                        if (nums[end - 1] == target) {
                            end--;
                            break;
                        }
                        right2 = end - 1;
                    }
                }
                return new int[]{start, end};
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution34().searchRange(new int[]{0, 0, 1, 2, 3, 3, 4}, 2)));
    }
}
