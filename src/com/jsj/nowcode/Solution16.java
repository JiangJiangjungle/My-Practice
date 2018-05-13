package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode result;
        ListNode temp;
        if (list1.val < list2.val) {
            result = list1;
        } else {
            result = list2;
        }
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp = list1.next;
                list1.next = list2;
                list1 = temp;
            } else {
                temp = list2.next;
                list2.next = list1;
                list2 = temp;
            }
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
