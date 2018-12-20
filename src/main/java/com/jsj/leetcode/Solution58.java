package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-20
 * 题目描述：给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int lastStart = 0;
        int lastEnd = 0;
        boolean started = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && !started) {
                lastStart = i;
                started = true;
            } else if (s.charAt(i) == ' ' && started) {
                lastEnd = i;
                started = false;
            }
        }
        if (started) {
            lastEnd = s.length();
        }
        return lastEnd - lastStart;
    }
}
