package com.jsj.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jsj
 * @since 2018-12-25
 * 题目描述：给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        doFullJustify(words, maxWidth, list, 0);
        return list;
    }

    private void doFullJustify(String[] words, int maxWidth, List<String> list, int start) {
        if (start >= words.length) return;
        String now;
        int leftWidth = maxWidth;
        int nowIndex = words.length - 1;
        int countNumber = 0;
        for (int i = start; i < words.length; i++) {
            now = words[i];
            if (checkFeasibility(now, leftWidth, countNumber)) {
                leftWidth -= now.length();
                countNumber++;
            } else {
                nowIndex = i - 1;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(maxWidth);
        if (nowIndex == start || nowIndex == words.length - 1) {
            for (int i = start; i <= nowIndex; i++) {
                sb.append(words[i]);
                if (leftWidth > 0) {
                    sb.append(" ");
                    leftWidth--;
                }
            }
            for (int j = 0; j < leftWidth; j++) {
                sb.append(" ");
            }
        } else {
            countNumber--;
            for (int i = start, length; i <= nowIndex; i++, countNumber--, leftWidth -= length) {
                sb.append(words[i]);
                if (i == nowIndex) break;
                length = leftWidth / countNumber;
                if (leftWidth % countNumber != 0) {
                    length++;
                }
                for (int j = 0; j < length; j++) {
                    sb.append(" ");
                }
            }
        }
        list.add(sb.toString());
        doFullJustify(words, maxWidth, list, nowIndex + 1);
    }

    private boolean checkFeasibility(String now, int leftWidth, int number) {
        return leftWidth >= now.length() + number;
    }

    public static void main(String[] args) {
        List<String> list = new Solution68().fullJustify(new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"}, 16);
        if (list != null) {
            for (String aList : list) {
                System.out.println(aList);
            }
        }
    }
}
