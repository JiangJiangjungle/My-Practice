package com.jsj.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jsj
 * @since 2018-12-5
 * 题目描述：给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) return head;
        Deque<ListNode> stack = new ArrayDeque<>(k);
        ListNode last = null;
        ListNode now = head;
        ListNode next = now == null ? null : getNextK(now, k);
        ListNode realHead = next == null ? now : next;
        ListNode tmp;
        int count = 0;
        while (now != null) {
            while (now != null && count < k) {
                stack.push(now);
                if (count == k - 1 && last != null) {
                    last.next = now;
                }
                now = now.next;
                count++;
            }
            if (count < k) {
                break;
            }
            tmp = now;
            for (now = stack.pop(); !stack.isEmpty(); now = now.next) {
                now.next = stack.pop();
            }
            now.next = tmp;
            last = now;
            now = last.next;
            count = 0;
        }
        return realHead;
    }

    private ListNode getNextK(ListNode now, int k) {
        for (int count = 1; count < k && now != null; count++) {
            now = now.next;
        }
        return now;
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
        node.next.next.next.next = new ListNode(5);
        ListNode newNode = new Solution25().reverseKGroup(node, 1);
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}
