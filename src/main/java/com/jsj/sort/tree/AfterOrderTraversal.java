package com.jsj.sort.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 二叉树的后序遍历
 */
public class AfterOrderTraversal {

    /**
     * 非递归实现
     *
     * @param head
     */
    public static void afterOreder(TreeNode head) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();
        deque.offerLast(head);
        for (TreeNode tmp; !deque.isEmpty(); ) {
            for (tmp = deque.pollLast(); tmp != null; tmp = tmp.left) {
                deque.offerLast(tmp);
            }
            for (; !deque.isEmpty(); ) {
                tmp = deque.peekLast();
                if (tmp.right != null && !set.contains(tmp)) {
                    set.add(tmp);
                    deque.offerLast(tmp.right);
                    break;
                } else {
                    deque.pollLast();
                    System.out.println(tmp.value);
                    set.remove(tmp);
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
        afterOreder(head);
    }
}
