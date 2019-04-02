package com.jsj.sword_for_offer.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * <p>
 * 思路:用两个大小为52（大小写字母长度）数组分别维护出现次数和最后出现位置。
 */
public class Solution34 {

    public int FirstNotRepeatingChar2(String str) {
        Map<Character, Integer> record = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (record.containsKey(str.charAt(i))) {
                record.put(str.charAt(i), -1);
            } else {
                record.put(str.charAt(i), i);
            }
        }
        int value = -1;
        for (Map.Entry<Character, Integer> entry : record.entrySet()) {
            value = entry.getValue();
            if (value != -1) {
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new Solution34().FirstNotRepeatingChar2("googgle"));
    }
}
