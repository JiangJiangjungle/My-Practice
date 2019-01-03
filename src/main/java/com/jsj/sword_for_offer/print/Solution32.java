package com.jsj.sword_for_offer.print;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * <p>
 * 思路：用自定义的排序方法进行排序然后依次输出
 */
public class Solution32 {
    public String PrintMinNumber(int[] numbers) {
        int count = 0;
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
            count += strings[i].length();
        }
        Arrays.sort(strings, (o1, o2) -> {
            int i = 0, j = 0;
            for (; !(i == o1.length() - 1 && j == o2.length() - 1); ) {
                if (o1.charAt(i) != o2.charAt(j)) {
                    break;
                }
                if (i < o1.length() - 1) i++;
                if (j < o2.length() - 1) j++;
            }
            return o1.charAt(i) - o2.charAt(j);
        });
        StringBuilder sb = new StringBuilder(count);
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }
}
