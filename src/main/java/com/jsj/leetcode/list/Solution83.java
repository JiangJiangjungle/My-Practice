package com.jsj.leetcode.list;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author jsj
 * @date 2019-05-05
 */
public class Solution83 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        for (ListNode last = head, now = head.next; now != null; now = now.next) {
            if (now.val == last.val) {
                last.next = now.next;
            } else {
                last = now;
            }
        }
        return head;
    }
}
