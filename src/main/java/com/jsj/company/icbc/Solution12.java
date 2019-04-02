package com.jsj.company.icbc;

import java.util.Scanner;

public class Solution12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = trans(scanner.nextLine().split(" "));
            System.out.println(find(nums));
        }
    }

    private static int find(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        int tmp1 = -1, tmp2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                count++;
                if (tmp1 == -1) {
                    tmp1 = i;
                    continue;
                }
                tmp2 = i;
            }
        }
        if (count == 2) {
            return Math.abs(nums[tmp1] - nums[tmp2]);
        }
        for (int i = 0, left = -1, val; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            tmp1 = nums[i];
            if (left != -1) {
                tmp2 = nums[left];
                nums[left] = 0;
                nums[i] = tmp1 - tmp2;
                val = find(nums);
                if (val > max) {
                    max = val;
                }
                nums[i] = tmp2 - tmp1;
                val = find(nums);
                if (val > max) {
                    max = val;
                }
                nums[i] = tmp1;
                nums[left] = tmp2;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    tmp2 = nums[j];
                    nums[j] = 0;
                    nums[i] -= tmp2;
                    val = find(nums);
                    if (val > max) {
                        max = val;
                    }
                    nums[i] = tmp2 - tmp1;
                    val = find(nums);
                    if (val > max) {
                        max = val;
                    }
                    nums[i] = tmp1;
                    nums[j] = tmp2;
                }
            }
            left = i;
        }
        return max;
    }

    public static int[] trans(String[] strArray) {
        int[] nums = new int[strArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        return nums;
    }
}
