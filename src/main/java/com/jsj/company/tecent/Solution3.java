package com.jsj.company.tecent;

import java.util.Scanner;

/**
 * 2019-03-09
 */
public class Solution3 {

    public static long count(int n, int m) {
        long sum = 1;
        long count1 = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= n - m + 1) {
                sum *= i;
            }
            if (i <= m) {
                count1 *= i;
            }
        }
        sum /= count1;
        sum *= Math.pow(2, n - m);
        return (long) (sum % (1e9 + 7));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            int n = Integer.parseInt(strings[0]);
            int m = Integer.parseInt(strings[1]);
            str = scanner.nextLine();
            System.out.println(count(n, m));
        }
    }
}
