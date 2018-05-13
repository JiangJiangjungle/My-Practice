package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * <p>
 * 题目描述：一个链表中包含环，请找出该链表的环的入口结点。
 * <p>
 * 思路：两指针a和b同时从头结点出发，一个每次跳一下，另一个每次跳两下，直到相遇。此时从头结点再次出发一指针c,a与c皆为每次一跳，直至相遇，即为入口结点。
 */
public class Solution55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode one = pHead;
        ListNode two = pHead;

        try {
            do {
                one = one.next;
                two = two.next.next;
            } while (one != two);

            two = pHead;

            while (one != two) {
                one = one.next;
                two = two.next;
            }
        } catch (Exception e) {
            return null;
        }

        return one;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
