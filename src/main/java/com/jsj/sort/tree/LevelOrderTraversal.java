package com.jsj.sort.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的层序遍历
 */
public class LevelOrderTraversal {

    /**
     * 非递归实现
     *
     * @param head
     * @return
     */
    public static void levelOrder(TreeNode head) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(head);
        for (TreeNode tmp; !deque.isEmpty(); ) {
            for (int i = deque.size(); i > 0; i--) {
                tmp = deque.pollFirst();
                System.out.println(tmp.value);
                if (tmp.left != null) {
                    deque.offerLast(tmp.left);
                }
                if (tmp.right != null) {
                    deque.offerLast(tmp.right);
                }
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
        levelOrder(head);
    }
}
