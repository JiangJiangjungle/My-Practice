package com.jsj.leetcode.important;

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
        ListNode head = null;
        int minIndex = -1;
        for (ListNode last = null, now; checkEmpty(lists); minIndex = -1) {
            for (int i = 0; i < lists.length; i++) {
                if (null == lists[i]) {
                    continue;
                }
                if (minIndex == -1 || lists[minIndex].val > lists[i].val) {
                    minIndex = i;
                }
            }
            now = lists[minIndex];
            lists[minIndex] = now.next;
            if (last == null) {
                head = now;
            } else {
                last.next = now;
            }
            last = now;
        }
        return head;
    }

    private boolean checkEmpty(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return true;
            }
        }
        return false;
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
