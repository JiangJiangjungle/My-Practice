package com.jsj.company.tecent;

import java.util.Scanner;

public class Solution4 {

    public static int minLengthWindow(int[] nums, int m) {
        int[] hasfound = new int[m + 1];
        int cnt = 0, start = 0, minwindow = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            hasfound[nums[i]] += 1;
            //说明又找到一个chars中的字符
            if (hasfound[nums[i]] == 1) {
                cnt++;
            }
            //当chars全部找到之后，开始缩小窗口。
            if (cnt == m) {
                while (hasfound[nums[start]] > 1) {
                    hasfound[nums[start]] -= 1;
                    start++;
                }
                if (i - start + 1 < minwindow) {
                    minwindow = i - start + 1;
                }
            }
        }
        return minwindow;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            int m = Integer.parseInt(strings[1]);
            str = scanner.nextLine();
            strings = str.split(" ");
            int[] nums = trans(strings);
            System.out.println(minLengthWindow(nums, m));
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
