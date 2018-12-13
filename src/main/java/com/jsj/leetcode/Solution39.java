package com.jsj.leetcode;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-11
 * 题目描述：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        doCombinationSum(candidates, 0, target, list, stack);
        return list;
    }

    private void doCombinationSum(int[] candidates, int start, int target, List<List<Integer>> list, Deque<Integer> stack) {
        if (target < candidates[start]) return;
        List<Integer> result;
        int now;
        for (int i = start; i < candidates.length; i++) {
            now = target - candidates[i];
            if (now < 0) return;
            if (now == 0) {
                stack.addLast(candidates[i]);
                result = new ArrayList<>(stack);
                stack.pollLast();
                list.add(result);
                return;
            }
            stack.addLast(candidates[i]);
            doCombinationSum(candidates, i, now, list, stack);
            stack.pollLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution39().combinationSum(new int[]{2, 3, 6,7}, 7);
        if (list != null) {
            for (List<Integer> res : list) {
                System.out.println(Arrays.toString(res.toArray()));
            }
        }
    }
}
