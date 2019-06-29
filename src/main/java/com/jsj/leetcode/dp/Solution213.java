package com.jsj.leetcode.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
 * ！！！！这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 思路：分2种情况，偷窃了最后一个房间；没有偷窃最后一个房间
 *
 * @author jsj
 * @date 2019-06-29
 */
public class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //偷窃了最后一个房间的情况下的最大金额
        int[] record1 = new int[nums.length + 1];
        record1[nums.length - 1] = nums[nums.length - 1];
        //不偷窃最后一个房间的情况下的最大金额
        int[] record2 = new int[nums.length + 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            record1[i] = i == 0 ? record1[i + 1] : Math.max(nums[i] + record1[i + 2], record1[i + 1]);
            record2[i] = Math.max(nums[i] + record2[i + 2], record2[i + 1]);
        }
        return Math.max(record1[0], record2[0]);
    }
}
