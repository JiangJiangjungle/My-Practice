package com.jsj.sword_for_offer.string;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution44 {
    public String ReverseSentence(String str) {
        if (str == null || str.equals("") || str.equals(" ")) return str;
        char[] chars = str.toCharArray();
        int length = chars.length - 1;
        doReverse(chars, 0, length);
        int i = 0;
        int j = 0;
        while (i <= length) {
            if (chars[i] == ' ') {
                if (j < i) {
                    doReverse(chars, j, i - 1);
                }
                j = i + 1;
            }
            i++;
        }
        if (j < i) {
            doReverse(chars, j, i - 1);
        }

        StringBuilder sb = new StringBuilder(str.length());
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void doReverse(char[] chars, int start, int end) {
        int length = end - start;
        for (int i = start; i <= start + length / 2; i++) {
            swap(chars, i, end - i + start);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
