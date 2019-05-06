package com.jsj.leetcode.others;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 思路：分出两条链表，再合并。
 *
 * @author jsj
 * @date 2019-05-06
 */
public class Solution86 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftNode = null, rightHead = null, rightNode = null;
        for (ListNode now = head; now != null; now = now.next) {
            if (now.val < x) {
                if (leftHead == null) {
                    leftHead = now;
                } else {
                    leftNode.next = now;
                }
                leftNode = now;
            } else {
                if (rightHead == null) {
                    rightHead = now;
                } else {
                    rightNode.next = now;
                }
                rightNode = now;
            }
        }
        if (leftNode != null) {
            leftNode.next = rightHead;
        }
        if (rightNode != null) {
            rightNode.next = null;
        }
        return leftHead == null ? rightHead : leftHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head = new Solution86().partition(head, 4);
        System.out.println(" ");
    }
}
