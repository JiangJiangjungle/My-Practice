package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述：如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution54 {
    private int[] position = new int[128];
    private int[] count = new int[128];
    private int now = 0;

    //Insert one char from stringstream
    public void Insert(char ch) {
        position[ch] = now;
        count[ch] += 1;
        now++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int first = now + 1;
        char result = '#';
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1 && position[i] < first) {
                first = position[i];
                result = (char) i;
            }
        }
        return result;
    }
}
