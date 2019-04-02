package com.jsj.sword_for_offer.algo;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * <p>
 * 思路：利用快排后partition的位置进行判断，小于k则继续快排右边。。。
 */
public class Solution29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        k--;
        for (int tmp, low = 0, high = input.length - 1; low <= high; ) {
            tmp = partition(input, low, high);
            if (tmp == k) {
                break;
            } else if (tmp > k) {
                high = tmp - 1;
            } else {
                low = tmp + 1;
            }
        }
        for (int i = 0; i <= k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private int partition(int[] nums, int low, int high) {
        int val = nums[low];
        for (; low < high; high--) {
            if (nums[high] >= val) {
                continue;
            }
            swap(nums, low, high);
            for (; low < high && nums[low] <= val; low++) {
            }
            swap(nums, low, high);
        }
        return low;
    }

    private void swap(int[] nums, int low, int high) {
        int tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }

    public static void main(String[] args) {
        ArrayList<Integer> r = new Solution29().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 8);
        if (r != null) {
            for (Integer i : r) {
                System.out.println(i);
            }
        }
    }
}
