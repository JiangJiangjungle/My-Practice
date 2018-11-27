package com.jsj.leetcode;

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
        if (null == l1 && null == l2) return null;
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode pre1 = null;
        ListNode now1 = l1, now2 = l2;
        for (; now1 != null && now2 != null; ) {
            if (now2.val <= now1.val) {
                if (pre1 == null) {
                    pre1 = now2;
                    head = pre1;
                    now2 = now2.next;
                } else {
                    pre1.next = now2;
                    now2 = now2.next;
                    pre1 = pre1.next;
                }
                pre1.next = now1;
            } else {
                pre1 = now1;
                now1 = now1.next;
            }
        }
        while (now1 == null && now2 != null) {
            if (now2.val >= pre1.val) {
                pre1.next = now2;
                break;
            }
            pre1.next = now2;
            pre1 = pre1.next;
            pre1.next = now1;
            now2 = now2.next;
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
