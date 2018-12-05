package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-12-5
 * 题目描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode last = null;
        ListNode now = head;
        ListNode next = now == null ? null : now.next;
        ListNode realHead = next == null ? now : next;
        while (next != null) {
            if (last != null) {
                last.next = next;
            }
            now.next = next.next;
            next.next = now;
            last = now;
            now = now.next;
            next = now == null ? null : now.next;
        }
        return realHead;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode newNode = new Solution24().swapPairs(node);
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}
