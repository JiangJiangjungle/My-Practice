package com.jsj.leetcode.string;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-8
 * 题目描述：给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出: [0,9]
 * 解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2:
 * <p>
 * 输入:
 * s = "wordgoodstudentgoodword",
 * words = ["word","student"]
 * 输出: []
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>(words.length);
        Deque<String> stack = new ArrayDeque<>(words.length);
        findAndAdd(result, s, words, 0, stack);
        return result;
    }

    private void findAndAdd(List<Integer> result, String s, String[] words, int start, Deque<String> stack) {
        if (start == words.length - 1) {
            StringBuilder sb = new StringBuilder();
            String tmp;
            for (int i = 0; i < words.length - 1; i++) {
                tmp = stack.pollLast();
                sb.append(tmp);
                stack.push(tmp);
            }
            sb.append(words[start]);
            int index = s.indexOf(sb.toString());
            while (index >= 0 && !result.contains(index)) {
                result.add(index);
                index = s.indexOf(sb.toString(), index + 1);
            }
            return;
        }
        for (int i = start; i < words.length; i++) {
            swap(words, start, i);
            stack.push(words[start]);
            findAndAdd(result, s, words, start + 1, stack);
            stack.pop();
            swap(words, start, i);
        }
    }

    private void swap(String[] words, int i, int j) {
        String tmp = words[i];
        words[i] = words[j];
        words[j] = tmp;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution30().findSubstring("barfoodfsfdbarfoobarman", new String[]{"bar", "foo"});
        System.out.println(Arrays.toString(list.toArray()));
    }
}
