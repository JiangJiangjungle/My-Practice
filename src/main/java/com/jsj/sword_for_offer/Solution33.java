package main.java.com.jsj.sword_for_offer;

import java.util.TreeSet;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：用一个set维护，每取出一个最小数就存入3个相关的丑数
 */
public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 1) return index;
        TreeSet<Long> set = new TreeSet<>();
        set.add(2L);
        set.add(3L);
        set.add(5L);
        long temp = 1L;
        for (int i = 1; i < index; i++) {
            temp = set.first();
            set.remove(temp);
            set.add(temp * 2);
            set.add(temp * 3);
            set.add(temp * 5);
        }
        return (int) temp;
    }
}
