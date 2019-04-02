package com.jsj.company.netease;

import java.util.Scanner;

public class Solution1 {

    public static int last(int n, int m) {
        if (n == 0 || m == 0) return -1;
        if (n == 1) return 0;
        int number = 2;
        int x = m % number;
        while (number < n) {
            number++;
            x = (x + m) % number;
        }
        return x + 1;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            String str = in.nextLine();
            String[] s = str.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            System.out.println(last(n, m));
        }
    }
}
