package com.jsj.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 思路：record[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分,那么record[i]为true的情况为：
 * 存在一个0<=j<i，使得record[j]&& wordDict.contains(s.substring(j, i))为ture
 *
 * @author jsj
 * @date 2019-05-14
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // record[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] record = new boolean[n + 1];
        record[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (record[j] && wordDict.contains(s.substring(j, i))) {
                    record[i] = true;
                    break;
                }
            }
        }
        return record[n];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bc");
        list.add("cb");
        System.out.println(new Solution139().wordBreak("bccbbc", list));
    }
}
