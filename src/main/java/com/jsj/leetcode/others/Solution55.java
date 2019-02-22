package com.jsj.leetcode.others;

/**
 * @author jsj
 * @since 2018-12-19
 * 题目描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int start) {
        if (start >= nums.length - 1) return true;
        int jumpStep = nums[start];
        if (jumpStep == 0) return false;
        if (start + jumpStep >= nums.length - 1) return true;
        int longestMove = 0;
        int index = start + 1;
        int now;
        for (int i = 1; i <= jumpStep; i++) {
            now = nums[start + i] + i;
            if (longestMove < now) {
                longestMove = now;
                index = start + i;
            }
        }
        return canJump(nums, index);
    }

    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int[]{1, 1, 2, 2, 0, 1, 1}));
    }
}
