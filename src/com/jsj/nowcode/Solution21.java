package com.jsj.nowcode;

import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Solution21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int now = 0;
        int nowIndex = -1;
        int nextIndex;
        int top;
        for (int i = 0; i < popA.length; i++) {
            nextIndex = findIndex(popA[i], pushA);
            if (nextIndex == -1) return false;
            if (nextIndex > nowIndex) {
                while (popA[i] != pushA[now]) {
                    stack.push(pushA[now]);
                    now++;
                }
                now++;
                nowIndex = nextIndex;
            } else {
                top = stack.pop();
                if (top != popA[i]) return false;
            }

        }
        return true;
    }

    private int findIndex(int i, int[] popA) {
        for (int j = 0; j < popA.length; j++) {
            if (i == popA[j]) return j;
        }
        return -1;
    }
}
