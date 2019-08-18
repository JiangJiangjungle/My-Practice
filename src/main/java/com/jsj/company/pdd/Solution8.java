package com.jsj.company.pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Solution8 {
    public static int count(int[] arr, int l) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avg = sum / arr.length;
        boolean big = avg > l / 2;
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (big && arr[i] <= l / 2) {
                arr[i] += l;
            } else if (!big && arr[i] > l / 2) {
                arr[i] -= l;
            }
            sum += arr[i];
        }
        avg = sum / arr.length;
        Arrays.sort(arr);
        int d = 0;
        for (int i = 0; i < arr.length; i++) {
            d += Math.abs(avg - (arr.length - 1) / 2 + i - arr[i]);
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int l = Integer.parseInt(str.split(" ")[0]);
            int n = Integer.parseInt(str.split(" ")[1]);
            int[] arr = trans(scanner.nextLine().split(" "));
            System.out.println(count(arr,l));
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
