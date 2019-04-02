package com.jsj.leetcode.others;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-19
 * 题目描述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, Collection> map = new HashMap<>(32);
        doGroupAnagrams(strs, 0, list, map);
        return list;
    }

    private void doGroupAnagrams(String[] strs, int start, List<List<String>> list, Map<String, Collection> map) {
        if (start == strs.length) return;
        List<String> aList;
        char[] chars = strs[start].toCharArray();
        Map subMap = map;
        Map subSubmap;
        String key;
        if (chars.length == 0) {
            aList = (List<String>) map.get("");
            if (aList == null) {
                aList = new ArrayList<>();
                map.put("", aList);
                list.add(aList);
            }
            aList.add("");
            doGroupAnagrams(strs, start + 1, list, map);
            return;
        }
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                int left = i;
                while (chars[i] == chars[i + 1]) {
                    i++;
                    if (i == chars.length - 1) break;
                }
                key = new String(chars).substring(left, i + 1);
            } else {
                key = String.valueOf(chars[i]);
            }
            subSubmap = (Map) subMap.get(key);
            if (subSubmap == null) {
                if (i != chars.length - 1) {
                    subSubmap = new HashMap<String, Map>(2);
                } else {
                    subSubmap = new HashMap<String, List<String>>(2);
                }
                subMap.put(key, subSubmap);
            }
            subMap = subSubmap;
            if (i == chars.length - 1) {
                aList = (List<String>) subMap.get(key);
                if (aList == null) {
                    aList = new ArrayList<>();
                    aList.add(strs[start]);
                    subMap.put(key, aList);
                    list.add(aList);
                } else {
                    aList.add(strs[start]);
                }
            }
        }
        doGroupAnagrams(strs, start + 1, list, map);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"", "bac", "aaa", ""};
        List<List<String>> list = new Solution49().groupAnagrams(strings);
        if (list != null) {
            System.out.println("!");
            for (List<String> aList : list) {
                System.out.println(Arrays.toString(aList.toArray()));
            }
        }
    }
}
