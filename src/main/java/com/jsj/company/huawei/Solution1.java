package com.jsj.company.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5个节点，从（0，0）节点开始遍历所有点，最后返回（0，0），求最短路径
 * <p>
 * 思路；图（邻接矩阵）的深度遍历
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] ss = str.split(" ");
            int[][] positions = new int[6][2];
            for (int i = 1, j = 0; i <= 5; i++) {
                positions[i][0] = Integer.parseInt(ss[j++]);
                positions[i][1] = Integer.parseInt(ss[j++]);
            }
            double[][] matrix = new double[6][6];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = Math.sqrt(Math.pow(positions[i][0] - positions[j][0], 2) + Math.pow(positions[i][1] - positions[j][1], 2));
                }
            }
            System.out.println(circ(matrix));
        }
    }

    public static int circ(double[][] matrix) {
        boolean[] used = new boolean[matrix.length];
        int[] path = new int[matrix.length];
        Arrays.fill(path, 1, path.length, -1);
        used[0] = true;
        return (int) dfs(matrix, path, used, 1);
    }


    private static double dfs(double[][] matrix, int[] path, boolean[] used, int step) {
        if (step == matrix.length) {
            return matrix[path[step - 1]][0];
        }
        double min = Integer.MAX_VALUE;
        double tmp;
        for (int x = 1; x < matrix.length; x++) {
            if (!used[x]) {
                used[x] = true;
                path[step] = x;
                tmp = matrix[path[step - 1]][x] + dfs(matrix, path, used, step + 1);
                if (min == Integer.MAX_VALUE || tmp < min) {
                    min = tmp;
                }
                used[x] = false;
                path[step] = -1;
            }
        }
        return min;
    }
}
