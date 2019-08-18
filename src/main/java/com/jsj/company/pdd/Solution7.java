package com.jsj.company.pdd;

import java.util.Scanner;

public class Solution7 {
    public static int count(int n, int s) {
        int v = 1;
        for (int i = s / 2, count = 1; count <= s / 2 - n + 1; count++, i--) {
            v *= i;
        }
        for (int i = 1; i <= s / 2 - n + 1; i++) {
            v /= i;
        }
        return v;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int[] arr = trans(scanner.nextLine().split(" "));

            System.out.println(count(Integer.parseInt(str.split(" ")[0]),Integer.parseInt(str.split(" ")[1])));
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
