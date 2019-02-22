package com.jsj.company.icbc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 公司组织团建活动，到某漂流圣地漂流，现有如下情况：
 * 员工各自体重不一，第 i 个人的体重为 people[i]，每艘漂流船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 为节省开支，麻烦帮忙计算出载到每一个人所需的最小船只数(保证每个人都能被船载)。
 * <p>
 * 输入描述:
 * 第一行输入参与漂流的人员对应的体重数组，
 * <p>
 * 第二行输入漂流船承载的最大重量
 * <p>
 * 输出描述:
 * 所需最小船只数
 * <p>
 * 输入例子1:
 * 1 2
 * 3
 * <p>
 * 输出例子1:
 * 1
 */
public class Solution9 {

    public static int count(int[] arr, int num) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0, j = arr.length - 1, tmp; i <= j; j--) {
            tmp = arr[j];
            while (i < j && tmp + arr[i] <= num) {
                tmp += arr[i];
                i++;
            }
            count++;

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int[] arr = trans(str.split(" "));
            System.out.println(count(arr, scanner.nextInt()));
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
