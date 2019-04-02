package com.jsj.sword_for_offer.stack;

import java.util.*;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Solution21 {


    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> s = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            for (; !s.empty() && s.peek() == popA[popIndex]; popIndex++) {
                //出栈
                s.pop();
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution21().IsPopOrder(new int[]{1}, new int[]{2}));
    }
}
