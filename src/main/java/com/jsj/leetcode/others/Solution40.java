package com.jsj.leetcode.others;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-11
 * 题目描述：给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> repeat = new HashSet<>();
        doCombinationSum(candidates, 0, target, list, stack, repeat);
        return list;
    }

    private void doCombinationSum(int[] candidates, int start, int target, List<List<Integer>> list, Deque<Integer> stack, Set<String> repeat) {
        if (start >= candidates.length || target < candidates[start]) return;
        List<Integer> result;
        int now;
        for (int i = start; i < candidates.length; i++) {
            now = target - candidates[i];
            if (now < 0) return;
            if (now == 0) {
                stack.addLast(candidates[i]);
                result = new ArrayList<>(stack);
                stack.pollLast();
                if (repeat.add(getString(result))) {
                    list.add(result);
                }
                return;
            }
            stack.addLast(candidates[i]);
            doCombinationSum(candidates, i + 1, now, list, stack, repeat);
            stack.pollLast();
        }
    }

    private String getString(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution40().combinationSum2(new int[]{1}, 2);
        if (list != null) {
            for (List<Integer> res : list) {
                System.out.println(Arrays.toString(res.toArray()));
            }
        }
    }
}
