package com.jsj.leetcode.important;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 思路：归并排序，链表中点可以用一组快慢指针确定
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l1 = head, l2 = l1;
        for (; ; ) {
            l2 = l2.next;
            if (l2 == null) {
                break;
            }
            l2 = l2.next;
            if (l2 == null) {
                break;
            }
            l1 = l1.next;
        }
        l2 = l1.next;
        l1.next = null;
        l1 = sortList(head);
        l2 = sortList(l2);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null;
        for (ListNode now, last = null, now1 = l1, now2 = l2; now1 != null || now2 != null; ) {
            if (now2 == null || now1 != null && now1.val <= now2.val) {
                now = now1;
                now1 = now1.next;
            } else {
                now = now2;
                now2 = now2.next;
            }
            if (last == null) {
                head = now;
            } else {
                last.next = now;
            }
            last = now;
        }
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
