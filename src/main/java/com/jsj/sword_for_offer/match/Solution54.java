package com.jsj.sword_for_offer.match;

import java.util.*;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述：如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution54 {

    private Map<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.remove(ch);
        } else {
            map.put(ch, 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            return entry.getKey();
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        solution54.Insert('g');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('o');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('o');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('g');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('l');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('e');
        System.out.println(solution54.FirstAppearingOnce());
    }
}
