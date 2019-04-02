package com.jsj.sort.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的前序遍历
 */
public class PreOrderTraversal {

    /**
     * 非递归实现
     *
     * @param head
     */
    public static void preOreder(TreeNode head) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(head);
        for (TreeNode tmp; !deque.isEmpty(); ) {
            tmp = deque.pollLast();
            System.out.println(tmp.value);
            if (tmp.right != null) {
                deque.offerLast(tmp.right);
            }
            if (tmp.left != null) {
                deque.offerLast(tmp.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.left.right.left = new TreeNode(7);
        head.left.left.left = new TreeNode(6);
        preOreder(head);
    }
}
