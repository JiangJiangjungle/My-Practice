package main.java.com.jsj.leetcode;

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
        char[] chars = s.toCharArray();
        Map<Integer, Integer> map = new TreeMap<>();
        int unique;
        int res = 0;
        for (int i = 0; i < chars.length; i = unique + 1) {
            unique = findUnique(chars, i);
            if (res < unique - i + 1) {
                res = unique - i + 1;
            }
            map.put(i, unique);
        }
        int lasti = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = entry.getValue();
            if (i != 0) {
                for (int a = lasti + 1; a < i; a++) {
                    int count = findMax(chars, a, i, j);
                    if (count > res) {
                        res = count;
                    }
                }
            }
            lasti = i;
        }
        return res;
    }

    private int findMax(char[] chars, int x, int i, int j) {
        HashSet<Character> set = new HashSet<>();
        for (int a = x; a < i; a++) {
            set.add(chars[a]);
        }
        if (i == chars.length - 1) {
            return set.add(chars[i]) ? i - x + 1 : i - x;
        }
        for (int a = i; a <= j; a++) {
            if (!set.add(chars[a])) {
                return a - x;
            }
        }
        return j - x + 1;
    }

    private int findUnique(char[] chars, int i) {
        HashSet<Character> set = new HashSet<>();
        set.add(chars[i]);
        int j = i + 1;
        for (; j < chars.length; j++) {
            if (set.contains(chars[j])) {
                if (j == i + 1) {
                    return i;
                }
                return j - 1;
            }
            set.add(chars[j]);
        }
        return j - 1;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("aorjhguskzaahziwi"));
    }
}
