package com.jsj.company.icbc;

import java.util.Scanner;

/**
 * 小招喵喜欢吃喵粮。这里有 N 堆喵粮，第 i 堆中有 p[i] 粒喵粮。喵主人离开了，将在 H 小时后回来。
 * <p>
 * 小招喵可以决定她吃喵粮的速度 K （单位：粒/小时）。每个小时，她将会选择一堆喵粮，从中吃掉 K 粒。
 * 如果这堆喵粮少于 K 粒，她将吃掉这堆的所有喵粮，然后这一小时内不会再吃更多的喵粮。
 * <p>
 * 小招喵喜欢慢慢吃，但仍然想在喵主人回来前吃掉所有的喵粮。
 * <p>
 * 返回她可以在 H 小时内吃掉所有喵粮的最小速度 K（K 为整数）。
 * <p>
 * <p>
 * 输入描述:
 * 第一行输入为喵粮数组，以空格分隔的N个整数
 * <p>
 * 第二行输入为H小时数
 * <p>
 * 输出描述:
 * 最小速度K
 * <p>
 * 输入例子1:
 * 3 6 7 11
 * 8
 * <p>
 * 输出例子1:
 * 4
 */
public class Solution3 {
    private static int speed(String[] nums, int h) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Integer.valueOf(nums[i]);
        }
        int k = sum / h;
        if (sum % h != 0) {
            k++;
        }
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += Integer.valueOf(nums[i]) / k;
            if (Integer.valueOf(nums[i]) % k != 0) {
                tmp++;
            }
        }
        for (; tmp != h; ) {
            k++;
            tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                tmp += Integer.valueOf(nums[i]) / k;
                if (Integer.valueOf(nums[i]) % k != 0) {
                    tmp++;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] nums = str.split(" ");
            int h = scanner.nextInt();
            System.out.println(speed(nums, h));
        }
    }
}
