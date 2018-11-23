package main.java.com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;

        TreeNode temp;
        TreeNode head;

        temp = Convert(pRootOfTree.right);
        if (temp != null) {
            pRootOfTree.right = temp;
            temp.left = pRootOfTree;
        }

        if (pRootOfTree.left != null) {
            temp = Convert(pRootOfTree.left);
            head = temp;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = pRootOfTree;
            pRootOfTree.left = temp;
        } else {
            head = pRootOfTree;
        }
        return head;
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
