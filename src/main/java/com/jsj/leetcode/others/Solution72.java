package com.jsj.leetcode.others;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-12-27
 * 题目描述：给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        int[][] record = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(record[i], -1);
        }
        return doMinDistance(word1, 0, word2, 0, record);
    }

    private int doMinDistance(String word1, int start1, String word2, int start2, int[][] record) {
        if (start1 == word1.length()) {
            return word2.length() - start2;
        }
        if (start2 == word2.length()) {
            return word1.length() - start1;
        }
        if (record[start1][start2] != -1) {
            return record[start1][start2];
        }
        int count;
        if (word1.charAt(start1) == word2.charAt(start2)) {
            count = doMinDistance(word1, start1 + 1, word2, start2 + 1, record);
        } else {
            count = 1 + Math.min(doMinDistance(word1, start1, word2, start2 + 1, record), Math.min(doMinDistance(word1, start1 + 1, word2, start2 + 1, record), doMinDistance(word1, start1 + 1, word2, start2, record)));
        }
        record[start1][start2] = count;
        return record[start1][start2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution72().minDistance("intention", "execution"));
    }
}
