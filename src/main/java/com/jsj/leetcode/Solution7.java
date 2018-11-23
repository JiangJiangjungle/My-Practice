package main.java.com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-11-20
 * 题目描述：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。如果反转后整数溢出那么就返回 0
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class Solution7 {
    public int reverse(int x) {
        long res = 0L;
        int sig = 1;
        if (x < 0) {
            sig = -1;
            x = sig * x;
        }
        int a;
        for (; x > 0; x = x / 10) {
            a = x % 10;
            if (!(res == 0 && a == 0)) {
                res = res * 10 + a;
            }
        }
        if (res > Integer.MAX_VALUE) {
            return 0;
        }
        return sig * (int) res;
    }
}
