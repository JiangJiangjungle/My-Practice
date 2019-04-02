package com.jsj.company.huya;

import java.util.*;

public class Solution2 {

    public static List<List<Integer>> find(int n, int k) {
        List<List<Integer>> records = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        doFind(1, n, k, records, deque);
        return records;
    }

    private static void doFind(int low, int high, int k, List<List<Integer>> records, LinkedList<Integer> deque) {
        if (k == 0) {
            records.add(new ArrayList<>(deque));
            return;
        }
        for (int i = low; i <= high - k + 1; i++) {
            deque.offerLast(i);
            doFind(i + 1, high, k - 1, records, deque);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> records = find(5, 2);
        for (List<Integer> list : records) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
