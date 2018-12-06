package com.jsj.sword_for_offer.tree;

import java.util.LinkedList;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        if (pRoot.right != null && pRoot.left != null) {
            list1.addFirst(pRoot.left);
            list1.addLast(pRoot.right);
        } else return pRoot.left == null && pRoot.right == null;

        while (!list1.isEmpty() || !list2.isEmpty()) {
            if (!doCycleCheck(list1, list2)) {
                return false;
            }
            if (!doCycleCheck(list2, list1)) {
                return false;
            }
        }
        return true;
    }

    private boolean doCycleCheck(LinkedList<TreeNode> fromList, LinkedList<TreeNode> toList) {
        TreeNode temp1;
        TreeNode temp2;
        while (!fromList.isEmpty()) {
            temp1 = fromList.removeFirst();
            temp2 = fromList.removeLast();
            if (check(temp1, temp2)) {
                if (temp1.left != null) {
                    toList.addFirst(temp1.left);
                    toList.addLast(temp2.right);
                }
                if (temp1.right != null) {
                    toList.addFirst(temp1.right);
                    toList.addLast(temp2.left);
                }
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean check(TreeNode temp1, TreeNode temp2) {
        if (temp1.val != temp2.val) return false;
        if (temp1.left != null && temp2.right == null) {
            return false;
        }
        if (temp1.right != null && temp2.left == null) {
            return false;
        }
        if (temp2.left != null && temp1.right == null) {
            return false;
        }
        if (temp2.right != null && temp1.left == null) {
            return false;
        }
        return true;
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
