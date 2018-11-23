package main.java.com.jsj.sword_for_offer;

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
        String s = String.valueOf(n);
        int length = s.length();
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - 1; i++) {
            sb.append('9');
        }
        //最大的N-1位数，如N-1=3时，maxN_1=999
        int maxN_1 = Integer.valueOf(sb.toString());
        //除去最高位以后的数
        int next = Integer.valueOf(s.substring(1));
        if (chars[0] == '1') {
            return next + 1
                    + NumberOf1Between1AndN_Solution(maxN_1)
                    + NumberOf1Between1AndN_Solution(next);
        } else {
            return (chars[0] - '0' - 2) * NumberOf1Between1AndN_Solution(maxN_1)
                    + NumberOf1Between1AndN_Solution(next)
                    + NumberOf1Between1AndN_Solution(Integer.valueOf("1" + sb.toString()));
        }
    }
}
