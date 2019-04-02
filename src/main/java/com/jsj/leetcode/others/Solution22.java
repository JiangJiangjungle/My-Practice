package com.jsj.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jsj
 * @since 2018-11-27
 * 题目描述：给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);
        return res;
    }

    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res, String ans, int count1, int count2, int n) {
        if (count1 > n || count2 > n) return;
        if (count1 == n && count2 == n) res.add(ans);
        if (count1 >= count2) {
            String ans1 = new String(ans);
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans1 + ")", count1, count2 + 1, n);

        }
    }
}
