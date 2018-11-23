package main.java.com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * <p>
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode last = null;
        ListNode now = pHead;
        ListNode next = now.next;
        ListNode temp;

        while (next != null) {
            if (now.val == next.val) {
                temp = next;
                while (temp != null && temp.val == now.val) {
                    temp = temp.next;
                }
                if (temp != null) {
                    now = temp;
                    if (last != null) {
                        last.next = now;
                    } else {
                        pHead = now;
                    }
                    next = now.next;
                } else {
                    if (last == null) {
                        return null;
                    } else {
                        last.next = null;
                        next = null;
                    }
                }
            } else {
                last = now;
                now = next;
                next = next.next;
            }
        }
        return pHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
