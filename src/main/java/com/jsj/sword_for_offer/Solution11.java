package main.java.com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution11 {
    public int NumberOf1(int n) {
        int num = 0;
        while (n != 0) {
            n = n & (n - 1);
            num++;
        }
        return num;
    }
}
