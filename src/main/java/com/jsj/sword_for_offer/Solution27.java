package main.java.com.jsj.sword_for_offer;

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
        if (str == null || str.equals("")) return list;
        char[] chars = str.toCharArray();

        Set<String> result = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        doPermutation(chars, 0, result, stack);

        list.addAll(result);
        Collections.sort(list);
        return list;
    }

    private void doPermutation(char[] chars, int i, Set<String> result, Stack<Character> stack) {
        if (i == chars.length) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> temp = new Stack<>();
            char ch;
            while (!stack.empty()) {
                ch = stack.pop();
                sb.append(ch);
                temp.push(ch);
            }
            while (!temp.empty()) {
                stack.push(temp.pop());
            }
            result.add(sb.toString());
            return;
        }
        for (int x = i; x < chars.length; x++) {
            swap(chars, i, x);
            stack.push(chars[i]);
            doPermutation(chars, i + 1, result, stack);
            stack.pop();
            swap(chars, i, x);
        }
    }


    private void swap(char[] chars, int i, int x) {
        char c = chars[i];
        chars[i] = chars[x];
        chars[x] = c;
    }
}
