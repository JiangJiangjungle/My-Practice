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
        for (int low = 0, high = array.length - 1, mid; low <= high; ) {
            mid = (low + high) / 2;
            if (array[mid] == k) {
                int lowBound = findBound(array, low, mid, k, true);
                int highBound = findBound(array, mid, high, k, false);
                return highBound - lowBound + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    private int findBound(int[] array, int low, int high, int k, boolean lowBound) {
        for (int mid; low <= high; ) {
            mid = (low + high) / 2;
            if (array[mid] != k) {
                if (lowBound) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                continue;
            }
            if (low == high) return mid;
            if (lowBound) {
                if (low == mid || array[mid - 1] != k) return mid;
                high = mid - 1;
            } else {
                if (array[mid + 1] != k) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3};
        System.out.println(new Solution37().GetNumberOfK(array, 3));
    }
}
