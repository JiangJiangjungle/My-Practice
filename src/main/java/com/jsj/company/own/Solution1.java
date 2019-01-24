package com.jsj.company.own;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 无序链表排序
 */
public class Solution1 {
    public static ListNode sort(ListNode node) {
        if (node.next == null) return node;
        List<ListNode> list = new ArrayList<>();
        for (ListNode now = node; now != null; now = now.next) {
            list.add(now);
        }
        list.sort(Comparator.comparingInt(o -> o.val));
        ListNode head = list.get(0);
        ListNode last = head;
        for (int i = 1; i < list.size(); i++) {
            last.next = list.get(i);
            last = last.next;
        }
        last.next = null;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(8);
        node.next.next.next.next = new ListNode(7);
        node = sort(node);
        for (ListNode now = node; now != null; now = now.next) {
            System.out.println(now.val);
        }
    }
}
