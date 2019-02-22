package com.jsj.leetcode.others;

/**
 * @author jsj
 * @since 2018-11-27
 * 题目描述：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode next = prev;
        for (int i = 0; i < n; i++) {
            if (next.next == null) {
                return head.next;
            }
            next = next.next;
        }
        for (; next.next != null; ) {
            prev = prev.next;
            next = next.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
