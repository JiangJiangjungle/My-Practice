package com.jsj.company.huawei;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int n = Integer.parseInt(str);
            int[][] positions = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] s = scanner.nextLine().split(" ");
                positions[i][0] = Integer.parseInt(s[0]);
                positions[i][1] = Integer.parseInt(s[1]);
            }
            System.out.println(find(positions));
        }
    }

    private static int find(int[][] positions) {
        int count = 0;
        for (int i = 0, tmp, tmp2, tmp3, tmp4; i < positions.length; i++) {
            tmp = 0;
            tmp2 = 0;
            tmp3 = 0;
            tmp4 = 0;
            for (int j = i + 1; j < positions.length; j++) {
                if (positions[j][0] == -1) {
                    continue;
                }
                if (positions[j][1] == positions[i][1]) {
                    tmp++;
                } else if (positions[j][0] == positions[i][0]) {
                    tmp2++;
                } else if (positions[j][0] - positions[i][0] == positions[j][1] - positions[i][1]) {
                    tmp3++;
                } else if (positions[j][0] - positions[i][0] == positions[i][1] - positions[j][1]) {
                    tmp4++;
                }
            }
            if (tmp >= tmp2 && tmp >= tmp3 && tmp >= tmp4) {
                for (int j = i + 1; j < positions.length; j++) {
                    if (positions[j][0] == -1) {
                        continue;
                    }
                    if (positions[j][1] == positions[i][1]) {
                        positions[j][0] = -1;
                    }
                }
            } else if (tmp2 >= tmp && tmp2 >= tmp3 && tmp2 >= tmp4) {
                for (int j = i + 1; j < positions.length; j++) {
                    if (positions[j][0] == -1) {
                        continue;
                    }
                    if (positions[j][0] == positions[i][0]) {
                        positions[j][0] = -1;
                    }
                }
            } else if (tmp3 >= tmp && tmp3 >= tmp2 && tmp3 >= tmp4) {
                for (int j = i + 1; j < positions.length; j++) {
                    if (positions[j][0] == -1) {
                        continue;
                    }
                    if (positions[j][0] - positions[i][0] == positions[j][1] - positions[i][1]) {
                        positions[j][0] = -1;
                    }
                }
            } else {
                for (int j = i + 1; j < positions.length; j++) {
                    if (positions[j][0] == -1) {
                        continue;
                    }
                    if (positions[j][0] - positions[i][0] == positions[i][1] - positions[j][1]) {
                        positions[j][0] = -1;
                    }
                }
            }
            count++;
        }
        return count;
    }
}
