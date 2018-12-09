package com.jsj.leetcode;

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
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (null==nums||nums.length==0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        boolean leftLocated = target >= nums[0];
        for (; left <= right; ) {
            mid = (left + right) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[0]) {
                if (leftLocated) {
                    if (nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    left = mid + 1;
                }
            } else {
                if (leftLocated) {
                    right = mid - 1;
                } else {
                    if (nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution33().search(new int[]{},4));
    }
}
