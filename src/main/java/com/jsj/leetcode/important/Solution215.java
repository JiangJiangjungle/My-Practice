package com.jsj.leetcode.important;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 思路：递归利用快排的partition返回值
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        int i = partition(nums, low, high);
        for (; i != k; i = partition(nums, low, high)) {
            if (i < k) {
                low = i + 1;
            } else {
                high = i - 1;
            }
        }
        return nums[i];
    }

    private int partition(int[] nums, int low, int high) {
        int num = nums[low];
        int i = low;
        for (int j = high; i < j; ) {
            if (nums[j] >= num) {
                j--;
                continue;
            }
            swap(nums, i, j);
            while (nums[i] <= num) {
                i++;
                if (j == i) {
                    break;
                }
            }
            swap(nums, i, j);
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
