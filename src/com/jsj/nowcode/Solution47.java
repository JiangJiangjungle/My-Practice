package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 思路：利用catch Exception进行递归，边界条件为：当数组没有越界时就输出结果
 */
public class Solution47 {
    public int Sum_Solution(int n) {
        int[] array = new int[1];
        int i = -n;
        int count = 0;
        try {
            array[i] = 0;
            return 0;
        } catch (Exception e) {
            count += n + Sum_Solution(n - 1);
        }
        return count;
    }
}
