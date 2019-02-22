package com.jsj.company.icbc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 假设你是一位很有爱的幼儿园老师，想要给幼儿园的小朋友们一些小糖果。但是，每个孩子最多只能给一块糖果。对每个孩子 i ，都有一个胃口值 gi ，
 * 这是能让孩子们满足胃口的糖果的最小尺寸；并且每块糖果 j ，都有一个尺寸 sj 。
 * 如果 sj >= gi ，我们可以将这个糖果 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块糖果。
 * <p>
 * <p>
 * 输入描述:
 * 第一行输入每个孩子的胃口值
 * <p>
 * 第二行输入每个糖果的尺寸
 * <p>
 * 孩子数和糖果数不超过1000
 * <p>
 * 输出描述:
 * 能满足孩子数量的最大值
 * <p>
 * 输入例子1:
 * 1 2 3
 * 1 1
 * <p>
 * 输出例子1:
 * 1
 */
public class Solution6 {

    public static int findMax(int[] kids, int[] candy) {
        Arrays.sort(kids);
        Arrays.sort(candy);
        int max = 0;
        for (int i = 0, j = 0; j < candy.length; j++) {
            if (kids[i] <= candy[j]) {
                max++;
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");
            int[] kids = new int[strArray.length];
            for (int i = 0; i < kids.length; i++) {
                kids[i] = Integer.parseInt(strArray[i]);
            }
            str = scanner.nextLine();
            strArray = str.split(" ");
            int[] candy = new int[strArray.length];
            for (int i = 0; i < candy.length; i++) {
                candy[i] = Integer.parseInt(strArray[i]);
            }
            System.out.println(findMax(kids, candy));
        }
    }
}
