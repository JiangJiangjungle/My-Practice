package com.jsj.sword_for_offer.algo;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述；求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * <p>
 * 思路：找规律，归纳总结一下
 */
public class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0) return 0;
        if (n < 10) return 1;
        int result = 0;
        int x = n;
        int count = 1;
        while (x >= 10) {
            x = x / 10;
            count = count * 10;
        }
        int y = n - x * count;
        result += x==1 ? y + 1 : count;
        result += NumberOf1Between1AndN_Solution(y);
        result += x * NumberOf1Between1AndN_Solution(count - 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution31().NumberOf1Between1AndN_Solution(100));
    }
}
