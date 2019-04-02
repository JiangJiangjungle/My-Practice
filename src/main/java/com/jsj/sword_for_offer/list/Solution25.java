package com.jsj.sword_for_offer.list;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 思路：创建复制节点后存入map，key为原节点.
 * 思路2：
 * 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
 * 2、遍历链表，A1->random = A->random->next;
 * 3、将链表拆分成原链表和复制后的链表
 */
public class Solution25 {

    public RandomListNode Clone(RandomListNode pHead) {
        for (RandomListNode now = pHead, tmp; now != null; now = now.next) {
            tmp = new RandomListNode(now.label);
            tmp.next = now.next;
            tmp.random = now.random;
            now.next = tmp;
            now = tmp;
        }
        RandomListNode newHead = pHead.next;
        for (RandomListNode now = pHead, tmp; now != null; now = now.next) {
            tmp = now.next;
            if (tmp.random != null) {
                tmp.random = tmp.random.next;
            }
            now.next = tmp.next;
        }
        return newHead;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        node.next = new RandomListNode(2);
        node.next.next = new RandomListNode(3);
        node.next.next.next = new RandomListNode(4);
        node.next.next.next.next = new RandomListNode(5);
        node.random = node.next.next;
        node.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next;
        RandomListNode node2 = new Solution25().Clone(node);
        System.out.println(node2);
    }
}
