package com.jsj.sword_for_offer.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution26 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        Deque<TreeNode> deque = new LinkedList<>();
        doConvert(pRootOfTree, deque);
        return deque.pollFirst();
    }

    private void doConvert(TreeNode pRootOfTree, Deque<TreeNode> deque) {
        if (pRootOfTree == null) return;
        doConvert(pRootOfTree.left, deque);
        TreeNode last = deque.peekLast();
        pRootOfTree.left = last;
        if (last != null) {
            last.right = pRootOfTree;
        }
        deque.addLast(pRootOfTree);
        doConvert(pRootOfTree.right, deque);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
