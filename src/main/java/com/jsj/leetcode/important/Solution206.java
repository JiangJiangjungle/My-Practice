package com.jsj.leetcode.important;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        for (ListNode last = null, now = head, next; now != null; ) {
            next = now.next;
            now.next = last;
            last = now;
            if (next == null) {
                newHead = now;
            }
            now = next;
        }
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
