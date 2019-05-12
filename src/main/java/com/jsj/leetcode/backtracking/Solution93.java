package com.jsj.leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 思路：被"."分割的每一个数字，在限定条件下获取，再进行递归
 *
 * @author jsj
 * @date 2019-05-08
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(4);
        restoreIpAddresses(s, 0, deque, list);
        return list;
    }

    private void restoreIpAddresses(String s, int start, Deque<Integer> deque, List<String> list) {
        if (deque.size() == 4) {
            if (start != s.length()) {
                return;
            }
            Integer tmp;
            StringBuilder sb = new StringBuilder(s.length() + 3);
            for (int i = 1; i <= 4; i++) {
                tmp = deque.pollFirst();
                sb.append(tmp);
                if (i < 4) {
                    sb.append(".");
                }
                deque.offerLast(tmp);
            }
            list.add(sb.toString());
            return;
        }
        for (int end = start + 3; end > start; end--) {
            int leftLength = s.length() - end;
            if (3 - deque.size() > leftLength) {
                continue;
            }
            if (3 * (3 - deque.size()) < leftLength) {
                break;
            }
            //避免类似"01"合并成1的情况
            if (s.charAt(start) == '0' && end - start > 1) {
                continue;
            }
            Integer val = Integer.parseInt(s.substring(start, end));
            if (val > 255) {
                continue;
            }
            deque.offerLast(val);
            restoreIpAddresses(s, end, deque, list);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution93().restoreIpAddresses("010010");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
