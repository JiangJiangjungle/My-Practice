package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-18
 * 题目描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Solution45 {
    public int jump(int[] nums) {
        int count = 0;
        int maxIndex;
        for (int i = 0; i < nums.length - 1; ) {
            if (nums[i] + i >= nums.length - 1) {
                count++;
                break;
            }
            maxIndex = Integer.MIN_VALUE;
            for (int j = 1; j <= nums[i]; j++) {
                if (Integer.MIN_VALUE == maxIndex || nums[i + j] + j > nums[maxIndex + i] + maxIndex) {
                    maxIndex = j;
                }
            }
            i += maxIndex;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution45().jump(new int[]{2,3,1,1,4}));
    }
}
