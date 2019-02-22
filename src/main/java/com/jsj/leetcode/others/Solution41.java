package com.jsj.leetcode.others;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jsj
 * @since 2018-12-11
 * 题目描述：给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间(..做不到)。
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null) return 1;
        Set<Integer> repeat = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                repeat.add(nums[i]);
            }
        }
        int i = 1;
        for (; i <= repeat.size(); i++) {
            if (!repeat.contains(i)) return i;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution41().firstMissingPositive(new int[]{2, 1}));
    }
}
