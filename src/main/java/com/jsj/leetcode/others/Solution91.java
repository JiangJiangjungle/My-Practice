package com.jsj.leetcode.others;

import java.util.Arrays;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 思路：00,01这种例子是哪里来的。。坑货
 *
 * @author jsj
 * @date 2019-05-08
 */
public class Solution91 {
    public int numDecodings(String s) {
        int[] record = new int[s.length()];
        Arrays.fill(record, -1);
        return numDecodings(s, 0, record);
    }

    private int numDecodings(String s, int start, int[] record) {
        if (start < s.length() && s.charAt(start) == '0') {
            record[start] = 0;
            return record[start];
        }
        if (start >= s.length() - 1) {
            record[start] = 1;
        }
        if (record[start] != -1) {
            return record[start];
        }
        int val = 0;
        int num = Integer.parseInt(s.substring(start, start + 2));
        if (start < s.length() - 1 && num < 27) {
            if (start == s.length() - 2) {
                val = 1;
            } else {
                if (record[start + 2] == -1) {
                    record[start + 2] = numDecodings(s, start + 2, record);
                }
                val = record[start + 2];
            }
            if (num == 10 || num == 20) {
                record[start] = val;
                return record[start];
            }
        }
        if (record[start + 1] == -1) {
            record[start + 1] = numDecodings(s, start + 1, record);
        }
        record[start] = val + record[start + 1];
        return record[start];
    }

    /**
     * 第二种做法
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int length = s.length();
        int[] num = new int[length];
        num[0] = 1;
        for(int i = 1; i < length; i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) > '2' || s.charAt(i-1) =='0' ){
                    return 0;
                }
                if(i==1){
                    num[i] = 1;
                }else{
                    num[i] = num[i-2];
                }
                continue;
            }
            if((s.charAt(i) > '6' && s.charAt(i-1) == '2') || s.charAt(i-1) >= '3' || s.charAt(i-1)=='0' ){
                num[i] = num[i-1];
                continue;
            }
            if(i==1){
                num[i] = 2;
            }else{
                num[i] = num[i-1] + num[i-2];
            }
        }
        return num[length-1];
    }
}
