package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        ListNode kTh = head;
        for (int i = 0; i < k; i++) {
            if (kTh != null) {
                kTh = kTh.next;
            } else {
                return null;
            }
        }
        ListNode result = head;
        while (kTh != null) {
            kTh = kTh.next;
            result = result.next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
