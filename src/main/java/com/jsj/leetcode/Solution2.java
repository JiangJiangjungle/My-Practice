package com.jsj.leetcode;

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
        ListNode head = null;
        ListNode now;
        ListNode last = head;
        boolean tag = false;
        for (int value = 0; tag || l1 != null || l2 != null; value = 0) {
            if (tag) {
                value++;
            }
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            if (tag = (value >= 10)) {
                value -= 10;
            }
            now = new ListNode(value);
            if (head == null) {
                head = now;
                last = head;
                continue;
            }
            last.next = now;
            last = now;
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
