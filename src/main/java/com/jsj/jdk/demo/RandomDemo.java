package com.jsj.jdk.demo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class RandomDemo {
    public static Random random = new Random();

    public static void main(String[] args) throws Exception {
        int number = 6;
        int len = 2 * number - 1;
        boolean[][] record = new boolean[len][len];
        Deque<String> deque = new ArrayDeque<>();
        test(record, number, len / 2, len / 2, deque);
        System.out.println(Arrays.toString(deque.toArray()));
    }

    public static boolean test(boolean[][] record, int number, int i, int j, Deque<String> deque) {
        if (number == 0) return true;
        boolean succeed = false;
        record[i][j] = true;
        deque.offerLast(i + " " + j);
        int index = random.nextInt(4);
        if (!record[i][j + 1]) {
            if (index == 0 || record[i][j - 1] && record[i + 1][j] && record[i - 1][j]) {
                succeed = test(record, number - 1, i, j + 1, deque);
            }
        }
        if (succeed) {
            return succeed;
        }
        if (!record[i][j - 1]) {
            if (index == 1 || record[i + 1][j] && record[i - 1][j]) {
                succeed = test(record, number - 1, i, j - 1, deque);
            }
        }
        if (succeed) {
            return succeed;
        }
        if (!record[i + 1][j]) {
            if (index == 2 || record[i - 1][j]) {
                succeed = test(record, number - 1, i + 1, j, deque);
            }
        }
        if (succeed) {
            return succeed;
        }
        if (!record[i - 1][j]) {
            succeed = test(record, number - 1, i - 1, j, deque);
        }
        if (!succeed) {
            record[i][j] = false;
            deque.pollLast();
        }
        return succeed;
    }
}
