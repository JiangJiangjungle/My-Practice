package com.jsj.sword_for_offer.tree;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 思路：判断数组前一部分全部小于根节点，后面一部分全部大于根节点，再判断子节点是否是后序遍历的结果。
 */
public class Solution23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        int length = sequence.length;
        return length != 0 && doVerify(sequence, 0, length - 1);
    }

    private boolean doVerify(int[] sequence, int i, int j) {
        if (i + 1 == j || i == j) return true;
        int root = sequence[j];
        int index = i - 1;
        boolean hasMetBig = false;
        for (int x = i; x < j; x++) {
            if (sequence[x] > root) {
                hasMetBig = true;
            } else {
                if (hasMetBig) return false;
                index = x;
            }
        }
        if (index == i - 1) return doVerify(sequence, i, j - 1);
        if (index == j - 1) return doVerify(sequence, i, index);
        return doVerify(sequence, i, index) && doVerify(sequence, index + 1, j - 1);
    }
}
