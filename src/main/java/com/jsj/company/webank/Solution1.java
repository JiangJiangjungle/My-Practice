package com.jsj.company.webank;

import java.util.*;

public class Solution1 {
    public static int find(int[] numbers) {
        int count = 0;
        count += numbers[5];
        numbers[5] = 0;
        if (numbers[4] > 0) {
            count += numbers[4];
            numbers[0] -= numbers[4] * 11;
            numbers[4] = 0;
        }
        if (numbers[3] > 0) {
            count += numbers[3];
            if (numbers[1] < numbers[3] * 5) {
                numbers[0] -= (numbers[3] * 5 - numbers[1]) * 4;
            }
            numbers[1] -= numbers[3] * 5;
            numbers[3] = 0;
        }
        if (numbers[2] > 0) {
            count += numbers[2] / 4;
            int left = numbers[2] % 4;
            if (left > 0) {
                left = 36 - left * 9;
                count++;
                if (numbers[1] > 0) {
                    int now = left / (numbers[1] * 4);
                    numbers[1] -= now;
                    left -= now * 4;
                }
                if (numbers[0] > 0) {
                    numbers[0] -= left;
                }
            }
        }
        if (numbers[1] > 0) {
            count += numbers[1] / 9;
            int left = numbers[1] % 9;
            if (left > 0) {
                count++;
                numbers[0] -= 36 - left * 4;
            }
        }
        if (numbers[0] > 0) {
            count += numbers[0] / 36;
            if (numbers[0] % 36 > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(find(trans(str.split(" "))));
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
