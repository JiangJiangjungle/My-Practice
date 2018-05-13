package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:如果是合法的数值表达则返回该数字，否则返回0
 */
public class Solution49 {
    public int StrToInt(String str) {
        if (str == null || str.equals("")) return 0;
        char[] chars = str.toCharArray();
        int count = 0;
        int bei = 1;
        int tag = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > '9' || chars[i] < '0') {
                if (i == 0 && (chars[i] == '+' || chars[i] == '-')) {
                    if (chars[i] == '-') {
                        tag = -1;
                    }
                    continue;
                }
                return 0;
            }
            count += bei * (chars[i] - '0');
            bei *= 10;
        }
        return tag * count;
    }
}
