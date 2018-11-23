package main.java.com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Solution7 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int i = 2;
        int last = 1;
        int lastOfLast = 1;
        int temp;
        while (i < n) {
            temp = last + lastOfLast;
            lastOfLast = last;
            last = temp;
            i++;
        }
        return last;
    }
}
