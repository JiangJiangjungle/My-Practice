package com.jsj.company.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个长度为偶数的数组arr，将该数组中的数字两两配对并求和，在这些和中选出最大和最小值，
 * 请问该如何两两配对，才能让最大值和最小值的差值最小？
 * <p>
 * 一共2行输入。
 * 第一行为一个整数n，2<=n<=10000, 第二行为n个数，组成目标数组，每个数大于等于2，小于等于100。
 * <p>
 * 输出最小的差值。
 */
public class Solution5 {

    public static int func(int[] arr) {
        Arrays.sort(arr);
        int max = 0, min = Integer.MAX_VALUE;
        for (int left = 0, right = arr.length-1; left < right; left++, right--) {
            int sum = arr[left] + arr[right];
            if (sum > max) {
                max = sum;
            }
            if (sum < min) {
                min = sum;
            }
        }
        return max-min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] arr = trans(in.nextLine().split(" "));
        System.out.println(func(arr));
    }


    public static int[] trans(String[] strArray) {
        int[] nums = new int[strArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        return nums;
    }
}
