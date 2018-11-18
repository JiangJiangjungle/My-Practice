package com.jsj.sword_for_offer;

import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Solution15 {
    public ListNode ReverseList(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        node = head;
        while (!stack.empty()) {
            node.val = stack.pop();
            node = node.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
