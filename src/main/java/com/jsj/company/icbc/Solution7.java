package com.jsj.company.icbc;

import java.util.Scanner;

/**
 * 给定一个字符串来代表一个员工的考勤纪录，这个纪录仅包含以下两个字符：
 * 'A' : Absent，缺勤
 * 'P' : Present，到场
 * 如果一个员工的考勤纪录中不超过两个'A'(缺勤),那么这个员工会被奖赏。
 * <p>
 * 如果你作为一个员工，想在连续N天的考勤周期中获得奖赏，请问有多少种考勤的组合能够满足要求
 * <p>
 * 输入描述:
 * 考勤周期的天数N（正整数）
 * <p>
 * 输出描述:
 * 这N天里能获得奖赏的考勤组合数
 * <p>
 * 输入例子1:
 * 3
 * <p>
 * 输出例子1:
 * 7
 */
public class Solution7 {
    public static int count(int n) { ;
        return n*(n-1)/2+n+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(count(scanner.nextInt()));
        }
    }

}
