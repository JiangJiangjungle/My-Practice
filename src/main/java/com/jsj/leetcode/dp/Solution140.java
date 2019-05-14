package com.jsj.leetcode.dp;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["c", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 思路：用遍历wordDict,若s.startsWith(word)，则计算wordBreak(s.substring(word.length()), wordDict);
 * 用一个Map做字典。
 *
 * @author jsj
 * @date 2019-05-14
 */
public class Solution140 {
    private Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> tmpList = wordBreak(s.substring(word.length()), wordDict);
                for (String tmp : tmpList) {
                    list.add(word + (tmp.equals("") ? "" : " ") + tmp);
                }
            }
        }
        map.put(s, list);
        return list;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("cat");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> list = new Solution140().wordBreak("catsanddog", wordDict);
        System.out.println(Arrays.toString(list.toArray()));
    }
}

