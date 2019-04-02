package com.jsj.sort.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的中序遍历
 */
public class MidOrderTraversal {

    /**
     * 非递归实现,返回树的最大深度
     *
     * @param head
     */
    public static int midOreder(TreeNode head) {
        int count = 0, max = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(head);
        for (TreeNode tmp; !deque.isEmpty(); ) {
            for (tmp = deque.pollLast(); tmp != null; tmp = tmp.left) {
                deque.offerLast(tmp);
                count++;
            }
            if (count > max) {
                max = count;
            }
            for (; !deque.isEmpty(); ) {
                tmp = deque.pollLast();
                System.out.println(tmp.value);
                if (tmp.right != null) {
                    deque.offerLast(tmp.right);
                    break;
                }
                count--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.left.right.left = new TreeNode(7);
        head.left.left.left = new TreeNode(6);
        System.out.println("树的最大深度：" + midOreder(head));
    }
}
