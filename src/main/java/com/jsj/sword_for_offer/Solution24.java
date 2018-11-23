package main.java.com.jsj.sword_for_offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 思路：利用后序遍历找到所有叶子节点并判断
 */
public class Solution24 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> aPath;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            if (count + root.val > target) {
                break;
            }
            stack.push(root);
            count += root.val;
            root = root.left;
        }

        HashSet<TreeNode> ban = new HashSet<>();
        TreeNode now;
        while (!stack.empty()) {
            now = stack.pop();
            if (!ban.contains(now)) {
                if (now.right != null) {
                    ban.add(now);
                    stack.push(now);
                    now = now.right;
                    while (now != null) {
                        if (count + now.val > target) {
                            break;
                        }
                        stack.push(now);
                        count += now.val;

                        now = now.left;
                    }
                    continue;
                } else if (now.left == null) {
                    //找到叶子结点
                    if (count == target) {
                        stack.push(now);
                        //将栈中数据转换成ArrayList
                        aPath = inJect(stack);
                        stack.pop();
                        paths.add(aPath);
                    }
                }
            }
            count -= now.val;
        }
        return paths;
    }

    private ArrayList<Integer> inJect(Stack<TreeNode> stack) {
        Stack<TreeNode> temp = new Stack<>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        TreeNode node;
        ArrayList<Integer> result = new ArrayList<>();
        while (!temp.empty()) {
            node = temp.pop();
            result.add(node.val);
            stack.push(node);
        }
        return result;
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
