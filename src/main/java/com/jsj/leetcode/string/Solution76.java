package com.jsj.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jsj
 * @since 2018-12-29
 * 题目描述：给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }
        return doMinWindow(s, 0, tMap);
    }

    private String doMinWindow(String s, int start, Map<Character, Integer> tMap) {
        String subString;
        String minSub = "";
        int firstIndex = -1;
        int secondIndex = -1;
        Map<Character, Integer> localMap = new HashMap<>(tMap);
        for (int i = start; i < s.length(); i++) {
            if (tMap.containsKey(s.charAt(i))) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (secondIndex == -1 && i > firstIndex + 1) {
                    secondIndex = i;
                }
                if (checkAndClear(localMap, s.charAt(i))) {
                    minSub = s.substring(firstIndex, i + 1);
                    break;
                }
            }
        }
        if (secondIndex != -1) {
            subString = doMinWindow(s, secondIndex, tMap);
            if (!"".equals(subString) && subString.length() < minSub.length()) {
                minSub = subString;
            }
        }
        return minSub;
    }

    private boolean checkAndClear(Map<Character, Integer> tMap, char charAt) {
        if (tMap.containsKey(charAt)) {
            int value;
            if ((value = tMap.get(charAt)) == 1) {
                tMap.remove(charAt);
            } else {
                tMap.put(charAt, value - 1);
            }
            return tMap.isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
