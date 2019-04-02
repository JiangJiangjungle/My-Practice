package com.jsj.sword_for_offer.array;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：统计一个数字在排序数组中出现的次数。
 * <p>
 * 思路：二分查找
 */
public class Solution37 {
    public int GetNumberOfK(int[] array, int k) {
        return GetNumberOfK(array, k, 0, array.length - 1);
    }

    private int GetNumberOfK(int[] array, int k, int low, int high) {
        int val = 0;
        for (int mid; low <= high; ) {
            mid = (low + high) / 2;
            if (array[mid] == k) {
                val++;
                val += GetNumberOfK(array, k, low, mid - 1);
                val += GetNumberOfK(array, k, mid + 1, high);
                break;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3};
        System.out.println(new Solution37().GetNumberOfK(array, 3));
    }
}
