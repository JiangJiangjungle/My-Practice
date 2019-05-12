package com.jsj.leetcode.list;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 思路：用4个指针，分别指向位置m前驱节点，m节点，n节点和位置n后驱节点，在找到m节点以后，直至找到n节点，修改指针指向。
 *
 * @author jsj
 * @date 2019-05-08
 */
public class Solution92 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode left = null, node1 = null, node2 = null, right = null;
        int count = 1;
        for (ListNode prev = null, current = head, next = current.next; current != null; current = next, next = next.next, count++) {
            if (count == m) {
                left = prev;
                node1 = current;
            }
            if (count > m) {
                current.next = prev;
            }
            prev = current;
            if (count == n) {
                right = next;
                node2 = current;
                break;
            }
        }
        if (left != null) {
            left.next = node2;
        } else {
            head = node2;
        }
        if (node1 != null) {
            node1.next = right;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new Solution92().reverseBetween(head, 2, 4);
        System.out.println(" ");
    }
}
