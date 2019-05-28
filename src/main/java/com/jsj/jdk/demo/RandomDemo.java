package com.jsj.jdk.demo;

import java.util.*;

public class RandomDemo {
    public static Random random = new Random();

    public static void main(String[] args) throws Exception {
        int number = 6;
        int len = 2 * number - 1;
        boolean[][] record = new boolean[len][len];
        Deque<String> deque = new ArrayDeque<>();
        test(record, number, len / 2, len / 2, deque);
        System.out.println(Arrays.toString(deque.toArray()));
        Map<String, List<String>> branches = getBranches(deque, record);
        //todo 根据deque拼接路径
        //todo 根据branches拼接岔路
    }

    private static Map<String, List<String>> getBranches(Deque<String> deque, boolean[][] record) {
        Map<String, List<String>> branches = new HashMap<>();
        int len = deque.size();
        String position = deque.pollLast();
        deque.offerFirst(position);
        for (int i = 0; i < len - 2; i++) {
            position = deque.pollLast();
            if (random.nextBoolean()) {
                String[] numbers = position.split(" ");
                int x = Integer.parseInt(numbers[0]);
                int y = Integer.parseInt(numbers[1]);
                List<String> path = getPath(record, x, y);
                if (path.size() > 0) {
                    branches.put(position, path);
                }
            }
            deque.offerFirst(position);
        }
        position = deque.pollLast();
        deque.offerFirst(position);
        return branches;
    }

    /**
     * 创建一条以x,y坐标为起点的岔路
     *
     * @param record
     * @param x
     * @param y
     * @return
     */
    private static List<String> getPath(boolean[][] record, int x, int y) {
        return new ArrayList<>();
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
