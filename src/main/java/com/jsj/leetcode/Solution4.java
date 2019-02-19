package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-11-18
 * 题目描述：给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 */
public class Solution4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = (nums1.length + nums2.length);
        boolean one = (index & 1) == 1;
        index /= 2;
        int low = 0, high = 0;
        for (int i = 0, j = 0, count = -1; count < index; count++) {
            low = high;
            if (j == nums2.length || i < nums1.length && nums1[i] <= nums2[j]) {
                high = nums1[i];
                i++;
            } else {
                high = nums2[j];
                j++;
            }
        }
        if (one) {
            return high;
        } else {
            return ((double) (low + high)) / 2;
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2, 2};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
