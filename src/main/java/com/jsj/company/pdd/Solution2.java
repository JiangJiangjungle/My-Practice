package com.jsj.company.pdd;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            int n = Integer.parseInt(strings[0]);
            int d = Integer.parseInt(strings[1]);
            String[] ss;
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                ss = scanner.nextLine().split(" ");
                map.put(Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));
            }
            System.out.println(getMax(map, d));
        }
    }

    private static int getMax(Map<Integer, Integer> map, int d) {
        int max = Integer.MIN_VALUE;
        int[] nums = new int[map.size()];
        int[] vals = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            vals[i] = entry.getKey();
            nums[i] = entry.getValue();
            i++;
        }
        for (int y = vals.length - 1, count = -1; y >= 0; y--) {
            for (int tmp = y - 1; tmp >= 0; tmp--) {
                if (Math.abs(nums[y] - nums[tmp]) >= d) {
                    count = vals[tmp] + vals[y];
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
