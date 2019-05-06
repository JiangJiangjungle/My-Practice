package com.jsj.leetcode.others;

import java.util.Arrays;

/**
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * <p>
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * <p>
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * <p>
 * 同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * <p>
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 * <p>
 * 思路：递归：判断s1和s2是否是扰乱字符串，s1和s2必须长度相等、所包含的元素相同
 * 在1～s1.length()-1之间存在一个长度i，将s1和s2划分成两个子字符串，这两个子字符串也应互为扰乱字符串，符合条件返回true，否则返回false
 *
 * @author jsj
 * @date 2019-05-06
 */
public class Solution87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        String temp1 = s1, temp2 = s2;
        char[] ch1 = temp1.toCharArray(), ch2 = temp2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if (!String.valueOf(ch1).equals(String.valueOf(ch2))) return false;
        for (int i = 1; i < s1.length(); i++) {
            String lefts1 = s1.substring(0, i), rights1 = s1.substring(i);
            String lefts2 = s2.substring(0, i), rights2 = s2.substring(i);
            if (isScramble(lefts1, lefts2) && isScramble(rights1, rights2)) return true;
            lefts2 = s2.substring(s1.length() - i);
            rights2 = s2.substring(0, s1.length() - i);
            if (isScramble(lefts1, lefts2) && isScramble(rights1, rights2)) return true;
        }
        return false;
    }
}
