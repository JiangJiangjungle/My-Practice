package com.jsj.leetcode.important;

/**
 * @author jsj
 * @since 2018-11-27
 * 题目描述：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        for (ListNode last = null, now, now1 = l1, now2 = l2; now1 != null || now2 != null; ) {
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
