package com.jsj.sword_for_offer;

import java.util.Stack;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 思路：维护一个二叉搜索树（实际上红黑树可能更好，即TreeSet）,利用中序遍历找到结点
 * 其他：用两个堆实现
 */
public class Solution63 {
    private int length = 0;
    private TreeNode root;

    public void Insert(Integer num) {

        if (length == 0) {
            root = new TreeNode(num);
            length++;

        } else {
            TreeNode temp = root;
            while (true) {
                if (temp.val >= num) {
                    if (temp.right != null) {
                        temp = temp.right;
                    } else {
                        temp.right = new TreeNode(num);
                        length++;
                        break;
                    }
                } else {
                    if (temp.left != null) {
                        temp = temp.left;
                    } else {
                        temp.left = new TreeNode(num);
                        length++;
                        break;
                    }
                }
            }
        }
    }

    public Double GetMedian() {
        if (root == null || length <= 0) return 0.0;
        if (length == 1) return (double) root.val;
        int i = length / 2;
        int j;
        if (length % 2 != 0) {
            i = length / 2 + 1;
            j = i;
        } else {
            j = i + 1;
        }
        double result = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        int count = 0;
        while (now != null) {
            stack.push(now);
            now = now.left;
        }
        while (!stack.empty()) {
            now = stack.pop();
            count++;
            if (count == i || count == j) {
                result += now.val;
            }
            if (now.right != null) {
                now = now.right;
                while (now != null) {
                    stack.push(now);
                    now = now.left;
                }
            }
        }
        return length % 2 == 0 ? result / 2 : result;

    }


    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
