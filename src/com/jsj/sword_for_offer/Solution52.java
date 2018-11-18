package com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution52 {
    public boolean match(char[] str, char[] pattern) {
        int i = 0;
        int j = 0;
        while (i < str.length && j < pattern.length) {
            if (str[i] != pattern[j]) {
                if (pattern[j] == '.') {
                    if (j + 1 == pattern.length || pattern[j + 1] != '*') {
                        i++;
                        j++;
                    } else {
                        if (check(str.length - 1 - i, j, pattern)) {
                            i++;
                        } else {
                            j += 2;
                        }
                    }
                } else {
                    j++;
                    if (j < pattern.length && pattern[j] == '*') {
                        j++;
                    } else {
                        return false;
                    }
                }
            } else {
                if (j + 1 == pattern.length || pattern[j + 1] != '*') {
                    i++;
                    j++;
                } else if (check(str.length - 1 - i, j + 2, pattern)) {
                    i++;
                } else {
                    j += 2;
                }
            }
        }
        return i >= str.length && (j >= pattern.length || allCotain(j, pattern));
    }

    private boolean allCotain(int j, char[] pattern) {
        for (int i = j; i < pattern.length; i++) {
            if (i == pattern.length - 1) return false;
            if (pattern[i] != '*' && pattern[i + 1] == '*') {
                i++;
            } else return false;
        }
        return true;
    }

    private boolean check(int length, int j, char[] pattern) {
        int count = 0;
        for (int i = j; i < pattern.length; i++) {
            if (pattern[i] != '*') {
                if (i == pattern.length - 1 || pattern[i + 1] != '*') {
                    count++;
                } else {
                    i++;
                }
            }
        }
        return count <= length;
    }
}
