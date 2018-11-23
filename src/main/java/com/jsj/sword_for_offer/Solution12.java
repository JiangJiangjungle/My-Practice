package main.java.com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution12 {
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1.0;
        if (exponent == 1) return base;
        if (exponent == -1) return 1 / base;
        double temp = Power(base, exponent / 2);
        temp *= temp;
        if ((exponent & 1) == 0) {
            return temp;
        } else if (exponent < 0) {
            return 1 / base * temp;
        }
        return base * temp;
    }
}
