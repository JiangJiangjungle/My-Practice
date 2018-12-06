package com.jsj.sword_for_offer.stack;

import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Solution20 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.empty()) {
            minStack.push(node);
        } else {
            int min = minStack.pop();
            minStack.push(min);
            if (node < min) {
                minStack.push(node);
            } else {
                minStack.push(min);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        int top = stack.pop();
        stack.push(top);
        return top;
    }

    public int min() {
        int minNum = minStack.pop();
        minStack.push(minNum);
        return minNum;
    }
}
