package com.jsj.sword_for_offer.match;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution53 {
    public boolean isNumeric(char[] str) {
        boolean idot = false;
        int idotIndex = -1;
        boolean e = false;
        int eIndex = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] > '9' || str[i] < '0') {
                if (i == str.length - 1) {
                    return false;
                }
                if (str[i] == '+' || str[i] == '-') {
                    if (i == 0 || e && eIndex == i - 1) {
                        continue;
                    }
                } else if (str[i] == 'e' || str[i] == 'E') {
                    if (i != 0 && !e) {
                        e = true;
                        eIndex = i;
                        if (!idot || idotIndex < eIndex - 1) {
                            continue;
                        }
                    }
                } else if (str[i] == '.' && !e && !idot) {
                    idot = true;
                    idotIndex = i;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
