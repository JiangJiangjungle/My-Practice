package main.java.com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return root1 != null && root2 != null
                && (root1.val == root2.val
                && isEqual(root1.left, root2.left)
                && isEqual(root1.right, root2.right)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2));
    }

    private boolean isEqual(TreeNode one, TreeNode two) {
        return (two == null || one != null)
                && (two == null || one.val == two.val && isEqual(one.left, two.left)
                && isEqual(one.right, two.right));
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
