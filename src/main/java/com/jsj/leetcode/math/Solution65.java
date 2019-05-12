package com.jsj.leetcode.math;

/**
 * @author jsj
 * @since 2018-12-25
 * 题目描述：验证给定的字符串是否为数字。
 * <p>
 * 例如:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。
 */
public class Solution65 {
    public boolean isNumber(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
    }
}
