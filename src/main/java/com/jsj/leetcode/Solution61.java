package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-20
 * 题目描述：给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Solution61 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode now;
        int len = 0;
        for (now = head; now != null; now = now.next, len++) {
        }
        int i = k % len;
        if (i == 0) return head;
        now = head;
        for (int count = len - i - 1; count > 0; count--) {
            now = now.next == null ? head : now.next;
        }
        ListNode newHead = now.next == null ? head : now.next;
        now.next = null;
        now = newHead;
        for (; now.next != null; now = now.next) {
        }
        now.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = new Solution61().rotateRight(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
