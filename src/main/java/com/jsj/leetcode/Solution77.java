package com.jsj.leetcode;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-29
 * 题目描述：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(k);
        doCombine(deque, k, n, list);
        return list;
    }

    private void doCombine(Deque<Integer> deque, int k, int n, List<List<Integer>> list) {
        if (deque.size() == k) {
            list.add(new ArrayList<>(deque));
            return;
        }
        for (int i = deque.size() == 0 ? 1 : deque.peekLast() + 1; i <= n; i++) {
            deque.addLast(i);
            doCombine(deque, k, n, list);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution77().combine(5, 2);
        for (List<Integer> aList : list) {
            System.out.println(Arrays.toString(aList.toArray()));
        }
    }
}
