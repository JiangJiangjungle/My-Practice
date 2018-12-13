package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-11
 * 题目描述：报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class Solution38 {
    public String countAndSay(int n) {
        String now = "1";
        if (n == 1) return now;
        for (int i = 1; i < n; i++) {
            now = countAndSay(now);
        }
        return now;
    }

    private String countAndSay(String last) {
        StringBuilder sb = new StringBuilder();
        char lastchar = last.charAt(0);
        int count = 1;
        for (int i = 0; i < last.length(); i++) {
            if (i == 0) continue;
            if (last.charAt(i) == lastchar) {
                count++;
            } else {
                sb.append(count);
                sb.append(lastchar);
                lastchar = last.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(lastchar);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(7));
    }
}
