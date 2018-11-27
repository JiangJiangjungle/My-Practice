package com.jsj.leetcode;

import java.util.Stack;

/**
 * @author jsj
 * @since 2018-11-27
 * 题目描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.empty()){
                return false;
            }
            if (ch == ')' && '(' != stack.pop()) {
                return false;
            } else if (ch == ']' && '[' != stack.pop()) {
                return false;
            } else if (ch == '}' && '{' != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
