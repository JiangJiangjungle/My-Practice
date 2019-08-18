package com.jsj.company.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小多想在美化一下自己的庄园。他的庄园毗邻一条小河，他希望在河边种一排树，共 M 棵。
 * 小多采购了 N 个品种的树，每个品种的数量是 Ai (树的总数量恰好为 M)。
 * 但是他希望任意两棵相邻的树不是同一品种的。小多请你帮忙设计一种满足要求的种树方案。
 * <p>
 * 第一行包含一个正整数 N，表示树的品种数量。
 * 第二行包含 N 个正整数，第 i (1 <= i <= N) 个数表示第 i 个品种的树的数量。
 * 数据范围：
 * 1 <= N <= 1000
 * 1 <= M <= 2000
 * <p>
 * 输出一行，包含 M 个正整数，分别表示第 i 棵树的品种编号 (品种编号从1到 N)。若存在多种可行方案，则输出字典序最小的方案。
 * 若不存在满足条件的方案，则输出"-"。
 */
public class Solution4 {
    public static String func(int start, int n, int[] count, int last) {
        String str = "-";
        if (start == n) return "";
        for (int i = 0; i < count.length; i++) {
            if (last == i) continue;
            if (count[i] == 0) continue;
            if (count[i] > (n - start + 1) / 2) continue;
            count[i]--;
            String tmp = func(start + 1, n, count, i);
            count[i]++;
            if (!"-".equals(tmp)) {
                str = start == n - 1 ? String.valueOf(i + 1) : (i + 1) + " " + tmp;
                break;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] arr = trans(in.nextLine().split(" "));
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            len += arr[i];
        }
        System.out.println(func(0, len, arr, -1));
    }


    public static int[] trans(String[] strArray) {
        int[] nums = new int[strArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        return nums;
    }
}
