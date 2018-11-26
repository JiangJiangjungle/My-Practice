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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            if (nums2.length == 0) {
                nums2 = nums1;
            }
            if ((1 == (nums2.length & 1))) {
                return nums2.length == 1 ? nums2[0] : nums2[nums2.length >> 1];
            } else {
                return ((double) nums2[nums2.length >> 1] + nums2[-1 + nums2.length >> 1]) / 2;
            }
        }
        int count = 0;
        int now1 = 0;
        int now2 = 0;
        int b = Math.min(nums1[0], nums2[0]);
        int a = b;
        while (count <= (nums1.length + nums2.length)>>1) {
            if (now2 == nums2.length || now1 < nums1.length && nums1[now1] < nums2[now2]) {
                a = b;
                b = nums1[now1];
                now1++;
            } else {
                a = b;
                b = nums2[now2];
                now2++;
            }
            count++;
        }
        if (1 == ((nums1.length + nums2.length) & 1)) {
            return b;
        } else {
            return ((double) a + b) / 2;
        }
    }
}
