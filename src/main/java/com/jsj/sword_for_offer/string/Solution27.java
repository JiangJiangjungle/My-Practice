package com.jsj.sword_for_offer.string;

import java.util.*;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * <p>
 * 思路：全排列
 */
public class Solution27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        doPermutation(str.toCharArray(), 0, list);
        return list;
    }

    private void doPermutation(char[] chars, int start, ArrayList<String> list) {
        if (start == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            doPermutation(chars, start + 1, list);
            swap(chars, start, i);
        }
    }


    private void swap(char[] chars, int i, int x) {
        char c = chars[i];
        chars[i] = chars[x];
        chars[x] = c;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new Solution27().Permutation("abc");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
