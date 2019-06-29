package com.jsj.leetcode.dp;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 思路：从左到右遍历，记录从0到当前下标范围内的最大连续乘积和最小连续乘积
 *
 * @author jsj
 * @date 2019-06-22
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        //一个保存最大的，一个保存最小的。
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            //更新最大值
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution152().maxProduct(new int[]{-3, 0, 1, -2}));
    }
}
