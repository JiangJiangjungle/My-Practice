package com.jsj.sword_for_offer.tree;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return pNode;
        TreeLinkNode temp;
        //如果有右子树，则找右子树的最左节点
        if (pNode.right != null) {
            temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        //没右子树，则找第一个当前节点是父节点左孩子的节点
        temp = pNode.next;
        while (temp != null) {
            if (temp.left == pNode) {
                return temp;
            } else {
                pNode = temp;
                temp = pNode.next;
            }
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
