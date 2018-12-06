package com.jsj.sword_for_offer.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode now = listNode;
        while (now != null) {
            stack.push(now.val);
            now = now.next;
        }
        ArrayList<Integer> list = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
