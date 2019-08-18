package com.jsj.company.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
 * 注意：
 * 1. 两个特工不能埋伏在同一地点
 * 2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 * <p>
 * <p>
 * 输入描述:
 * 第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
 * <p>
 * 第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
 * <p>
 * 输出描述:
 * 一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
 * <p>
 * 输入例子1:
 * 4 3
 * 1 2 3 4
 * <p>
 * 输出例子1:
 * 4
 * <p>
 * 例子说明1:
 * 可选方案 (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)
 * <p>
 * 输入例子2:
 * 5 19
 * 1 10 20 30 50
 * <p>
 * 输出例子2:
 * 1
 * <p>
 * 例子说明2:
 * 可选方案 (1, 10, 20)
 */
public class Solution6 {

    public static int func(int[] arr, int d) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0, lastj = 0; i < arr.length - 1; i++) {
            int j = i;
            for (; j + 1 < arr.length && (arr[j + 1] - arr[i]) <= d; j++) {
            }
            if (j - i + 1 >= 3) {
                count += (j - i + 1) * (j - i) * (j - i - 1) / 6;
                if (lastj - i + 1 >= 3) {
                    count -= (lastj - i + 1) * (lastj - i) * (lastj - i - 1) / 6;
                }
            }
            lastj = j;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] split = scanner.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int d = Integer.parseInt(split[1]);
            String[] strings = scanner.nextLine().split(" ");
            System.out.println(func(trans(strings), d));
        }
    }

    public static int[] trans(String[] strArray) {
        int[] nums = new int[strArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        return nums;
    }
}
