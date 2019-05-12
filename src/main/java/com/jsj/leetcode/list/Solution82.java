package com.jsj.leetcode.list;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @author jsj
 * @date 2019-04-25
 */
public class Solution82 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        if (head == null || head.next == null) {
            return head;
        }
        boolean repeat = false;
        for (ListNode last = null, now = head, next = head.next; next != null; next = next.next) {
            if (next.val != now.val) {
                if (repeat) {
                    if (last != null) {
                        last.next = next;
                    } else if (next.next == null) {
                        newHead = next;
                    }
                } else {
                    if (last == null) {
                        newHead = now;
                    }
                    last = now;
                }
                now = next;
                repeat = false;
            } else {
                if (next.next == null && last != null) {
                    last.next = null;
                }
                repeat = true;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head = new Solution82().deleteDuplicates(head);
        System.out.println(" ");
    }
}
