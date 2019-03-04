package com.jsj.leetcode.important;

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
 * <p>
 * 思路：利用二分分成4份，两两组成高低数组，低数组的最大值+高数组的最小值等于中位数
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

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        for (int low = 0, high = m, mid = (m + n + 1) / 2; low <= high; ) {
            int i = (low + high) / 2;
            int j = mid - i;
            if (i < high && nums2[j - 1] > nums1[i]) {
                low = i + 1; // i is too small
            } else if (i > low && nums1[i - 1] > nums2[j]) {
                high = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{2, 3, 4};
        System.out.println(findMedianSortedArrays2(num1, num2));
    }
}
