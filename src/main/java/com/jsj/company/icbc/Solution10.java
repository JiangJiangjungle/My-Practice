package com.jsj.company.icbc;

import java.util.*;

/**
 * 招商银行信用卡中心
 */
public class Solution10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int[] lens = trans(scanner.nextLine().split(" "));
            int[] powers = trans(scanner.nextLine().split(" "));
            int[][] pairs = new int[lens.length][2];
            for (int i = 0; i < lens.length; i++) {
                pairs[i][0] = lens[i];
                pairs[i][1] = powers[i];
            }
            System.out.println(find(pairs));
        }
    }

    private static int find(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        return 0;
    }

    public static int[] trans(String[] strArray) {
        int[] nums = new int[strArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        return nums;
    }
}
