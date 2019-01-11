package com.jsj.company.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。 | 是二进制的或(or)运算，例如 3 | 5 = 7。
 * <p>
 * 比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2 = 7。
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据为两个正整数 x , k。 满足 0 < x , k ≤ 2,000,000,000。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个数y。
 * <p>
 * <p>
 * 输入例子1:
 * 5 1
 * <p>
 * 输出例子1:
 * 2
 */
public class Solution4 {

    public static int find(int x, int k) {
        int count = 0;
        int y = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int bit = 0, tmp; x > 0; bit++) {
            tmp = x & 1;
            if (tmp == 0) {
                deque.addLast(bit);
                count = count == 0 ? 2 : count * 2;
                if (count-1 >= k) {
                    for (; k != 0; ) {
                        y += (k & 1) << deque.pollFirst();
                        k = k >> 1;
                    }
                }
            }
            x = x >> 1;
        }
        return y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(find(x, k));
        }
    }
}
