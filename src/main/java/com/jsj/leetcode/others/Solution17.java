package com.jsj.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jsj
 * @since 2018-11-21
 * 题目描述：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(digits.length());
        char now;
        for (int i = 0; i < digits.length() - 1; i++) {
            sb.append(getChar(digits.charAt(i), 0));
        }
        int x = digits.length() - 1;
        A:
        for (; x != -1; ) {
            B:
            for (int y = 0; y < 4; y++) {
                if (y==3&&!(digits.charAt(x)=='7'||digits.charAt(x)=='9')){
                    break;
                }
                now = getChar(digits.charAt(x), y);
                sb.append(now);
                if (x == digits.length() - 1) {
                    result.add(sb.toString());
                    while (isEnd(sb.charAt(x), digits.charAt(x))) {
                        sb.deleteCharAt(x);
                        x--;
                        if (sb.length() == 0) {
                            return result;
                        }
                        y= getStart(sb.charAt(x), digits.charAt(x));
                    }
                    sb.deleteCharAt(x);
                } else {
                    x++;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isEnd(char ch, char num) {
        if (num == '7') {
            return ch == 's';
        }
        if (num == '8') {
            return ch == 'v';
        }
        if (num == '9') {
            return ch == 'z';
        }
        return ch == ('a' + 3 * (num - '1') - 1);
    }

    private char getChar(char ch, int j) {
        if (ch == '8') {
            return (char) ('t' + j);
        }
        if (ch == '9') {
            return (char) ('w' + j);
        }
        return (char) ('a' + 3 * (ch - '2') + j);
    }

    private int getStart(char ch, char num) {
        if (num == '8') {
            return ch - 't';
        }
        if (num == '9') {
            return ch - 'w';
        }
        return ch - 3 * (num - '2') - 'a';
    }
}
