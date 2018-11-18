package com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入两个链表，找出它们的第一个公共结点。
 */
public class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = doFindLength(pHead1);
        int length2 = doFindLength(pHead2);
        if (length2 > length1) {
            for (int i = 0; i < length2 - length1; i++) {
                pHead2 = pHead2.next;
            }
        } else if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                pHead1 = pHead1.next;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    private int doFindLength(ListNode pHead1) {
        int count = 0;
        while (pHead1 != null) {
            pHead1 = pHead1.next;
            count++;
        }
        return count;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
