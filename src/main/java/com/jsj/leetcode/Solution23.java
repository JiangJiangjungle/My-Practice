package com.jsj.leetcode;

/**
 * @author jsj
 * @since 2018-11-27
 * 题目描述：合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) return null;
        ListNode head = null;
        ListNode last = head;
        for (int nowIndex = findSmall(lists); nowIndex != -1; nowIndex = findSmall(lists)) {
            if (head == null) {
                head = lists[nowIndex];
                last = head;
                lists[nowIndex] = lists[nowIndex].next;
                continue;
            }
            last.next = lists[nowIndex];
            last = lists[nowIndex];
            lists[nowIndex] = lists[nowIndex].next;
        }
        return head;
    }

    private int findSmall(ListNode[] lists) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (null == lists[i]) continue;
            if (index == -1 || min > lists[i].val) {
                index = i;
                min = lists[i].val;
            }
        }
        return index;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
