package com.jsj.company.netease;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] s = str.split(" ");
            int m = Integer.parseInt(s[1]);
            str = in.nextLine();
            int[] nums = trans(str.split(" "));
            System.out.println(find(nums, m));
        }
    }

    private static int find(int[] nums, int m) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= nums.length - m; i--) {
            if (nums[nums.length - m] <= 0) {
                if (m > 1) {
                    count += nums[nums.length - 1];
                }
                break;
            }
            if (i == nums.length - m) {
                count += nums[nums.length - m];
                nums[i] = 0;
                Arrays.sort(nums);
                i = nums.length;
                continue;
            }
            nums[i] -= nums[nums.length - m];
        }
        return count;
    }

    public static int[] trans(String[] strArray) {
        int[] nums = new int[strArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        return nums;
    }
}
