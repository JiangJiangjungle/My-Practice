package com.jsj.company.icbc;

import java.util.Arrays;
import java.util.Scanner;

public class Solution11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] highs = trans(scanner.nextLine().split(" "));
            System.out.println(find(k, highs));
        }
    }

    private static int find(int k, int[] highs) {
        Arrays.sort(highs);
        int count = 0;
        A:
        for (int i = 0, sum; i < highs.length; i++) {
            sum = 0;
            for (int j = highs.length - 1; j >= i; j--) {
                sum += (highs[j] - highs[i]);
                if (sum > k) {
                    break;
                } else if (j == i) {
                    if (sum == 0) {
                        break A;
                    }
                    highs[i] -= (k - sum) / (highs.length - i);
                    for (int x = highs.length - 1; x > i; x--) {
                        highs[x] = highs[i];
                    }
                    count++;
                    i = -1;
                    break;
                }
            }
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
