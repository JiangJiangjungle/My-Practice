package com.jsj.company.ali;

import java.util.Arrays;

/**
 * 对一个数组去重同时排序,对归并排序进行改进
 */
public class Solution1 {
    public static int distinctAndSort(int[] nums, int low, int high) {
        if (low == high) {
            return 1;
        }
        int len = 0;
        int mid = (low + high) / 2;
        int len1 = distinctAndSort(nums, low, mid);
        int len2 = distinctAndSort(nums, mid + 1, high);
        int[] tmp = new int[len1 + len2];
        for (int i = 0, x = low, y = mid + 1; i < tmp.length; i++) {
            if (i < len1) {
                tmp[i] = nums[x];
                x++;
            } else {
                tmp[i] = nums[y];
                y++;
            }
        }
        for (int x = 0, y = len1, i = low; !(y == (len1 + len2) && x == len1); i++, len++) {
            if (y == (len1 + len2) || x < len1 && tmp[x] <= tmp[y]) {
                if (y < (len1 + len2) && tmp[x] == tmp[y]) {
                    y++;
                }
                nums[i] = tmp[x];
                x++;
            } else {
                nums[i] = tmp[y];
                y++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 4, 2, 1, 1, 3, 5, 6};
        System.out.println(distinctAndSort(nums, 0, nums.length - 1));
        System.out.println(Arrays.toString(nums));
    }
}
