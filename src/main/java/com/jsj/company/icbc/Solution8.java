package com.jsj.company.icbc;

import java.util.Scanner;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * <p>
 * 输入描述:
 * 一串编码过的数字，比如12
 * <p>
 * 输出描述:
 * 解码方法的总数
 * <p>
 * 输入例子1:
 * 12
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * 例子说明1:
 * 12可以解码成“AB”，“A，B"这两种
 */
public class Solution8 {

    public static int count(String s, int start) {
        if (start == s.length()) return 0;
        if (start == s.length() - 1) return 1;
        int count = count(s, start + 1);
        if (Integer.parseInt(s.substring(start, start + 2)) <= 26) {
            int tmp = count(s, start + 2);
            if (tmp == 0) {
                tmp++;
            }
            count += tmp;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(count(str, 0));
        }
    }
}
