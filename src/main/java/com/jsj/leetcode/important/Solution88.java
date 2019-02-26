package com.jsj.leetcode.important;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 思路：从大往小排
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int now = m + n - 1, l1 = m - 1, l2 = n - 1; now >= 0; now--) {
            if (l2 < 0 || l1 >= 0 && nums1[l1] >= nums2[l2]) {
                nums1[now] = nums1[l1];
                l1--;
            } else {
                nums1[now] = nums2[l2];
                l2--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3, 5, 0, 0, 0};
        int[] num2 = new int[]{2, 4, 6};
        new Solution88().merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
}
