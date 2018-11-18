package com.jsj.leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author jsj
 * @since 2018-11-18
 * 题目描述：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 单位 数字。
 * <p>
 * 如果，我们将这两个数起来相加起来，则会返回出一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        int nowBit;
        ListNode head = null;
        ListNode now = null;
        ListNode next;
        for (ListNode pointer1 = l1, pointer2 = l2; pointer1 != null || pointer2 != null || count != 0; pointer1 = pointer1.next, pointer2 = pointer2.next) {
            if (pointer1 == null || pointer2 == null) {
                next = pointer1 == null ? pointer2 : pointer1;
                if (count == 0) {
                    now.next = next;
                    return head;
                }
                if (next != null) {
                    if (next.val == 9) {
                        now.next = new ListNode(0);
                        now = now.next;
                        next.val = 1;
                    } else {
                        next.val++;
                    }
                    now.next = next;
                } else {
                    now.next = new ListNode(count);
                }
                return head;
            }
            nowBit = pointer1.val + pointer2.val + count;
            if (nowBit >= 10) {
                nowBit -= 10;
                count = 1;
            } else {
                count = 0;
            }
            if (head == null) {
                head = new ListNode(nowBit);
                now = head;
            } else {
                next = new ListNode(nowBit);
                now.next = next;
                now = next;
            }
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
