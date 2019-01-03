package com.jsj.sword_for_offer.list;

/**
 * @author jsj
 * @since 2018-5-12
 * <p>
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution56 {

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null) return null;
        if (pHead.next == null) return pHead;
        ListNode head = null;
        boolean repeat = false;
        for (ListNode last = pHead, now = last.next, beforeLast = null; now != null; now = now.next) {
            if (now.val == last.val) {
                repeat = true;
                if (now.next == null && beforeLast != null) {
                    beforeLast.next = null;
                }
                continue;
            }
            if (head == null) {
                if (!repeat) {
                    head = last;
                } else if (now.next == null) {
                    head = now;
                }
            }
            if (!repeat) {
                beforeLast = last;
                last = now;
                continue;
            }
            if (beforeLast != null) {
                beforeLast.next = now;
            }
            last = now;
            repeat = false;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(3);
        ListNode head = h;
        h.next = new ListNode(3);
        h = h.next;
        h.next = new ListNode(3);
        h = h.next;
        h.next = new ListNode(3);
        h = h.next;
        h.next = new ListNode(4);
        h = h.next;
        h.next = new ListNode(4);
        h = h.next;
        h.next = new ListNode(6);

        h = new Solution56().deleteDuplication2(head);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
