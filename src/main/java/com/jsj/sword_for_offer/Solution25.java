package main.java.com.jsj.sword_for_offer;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 思路：创建复制节点后存入map，key为原节点.
 */
public class Solution25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode now = pHead;
        RandomListNode copyNow = newHead;
        RandomListNode temp;

        LinkedList<RandomListNode> list = new LinkedList<>();
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (now != null) {
            map.put(now, copyNow);
            temp = now.random;
            if (temp != null) {
                list.add(temp);
                copyNow.random = pHead;
            }
            temp = now.next;
            if (temp != null) {
                copyNow.next = new RandomListNode(temp.label);
                copyNow = copyNow.next;
            }
            now = temp;
        }
        copyNow = newHead;
        while (!list.isEmpty()) {
            if (copyNow.random != null) {
                copyNow.random = map.get(list.remove());
            }
            copyNow = copyNow.next;
        }
        return newHead;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
