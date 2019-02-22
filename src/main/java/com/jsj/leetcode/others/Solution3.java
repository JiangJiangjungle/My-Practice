package com.jsj.leetcode.others;

import java.util.*;

/**
 * @author jsj
 * @since 2018-11-18
 * 题目描述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> records = new HashMap<>();
        char ch;
        int max = 0;
        for (int i = 0, repeatIndex, lastStart = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (records.containsKey(ch)) {
                repeatIndex = records.get(ch);
                for (int j = lastStart; j < repeatIndex; j++) {
                    records.remove(s.charAt(j));
                }
                lastStart = repeatIndex + 1;
            }
            records.put(ch, i);
            if (max < records.size()) {
                max = records.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("bpfbhmipx"));
    }
}
