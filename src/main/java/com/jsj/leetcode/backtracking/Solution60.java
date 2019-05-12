package com.jsj.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jsj
 * @since 2018-12-20
 * 题目描述：给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        k--;
        List<Character> list = new LinkedList<>();
        int[] tmp = new int[n];
        tmp[0] = 1;
        for (int i = 0; i < n; i++) {
            list.add((char) (i + '1'));
            if (i != 0) {
                tmp[i] = tmp[i - 1] * (i + 1);
            }
        }
        StringBuilder sb = new StringBuilder(n);
        int index;
        for (int count = 0; count < n - 1; count++) {
            index = k / tmp[n - 2 - count];
            sb.append(list.remove(index));
            k -= index * tmp[n - 2 - count];
        }
        sb.append(list.remove(0));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution60().getPermutation(4, 4));
    }
}
