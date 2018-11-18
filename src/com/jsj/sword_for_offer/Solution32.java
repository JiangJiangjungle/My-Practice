package com.jsj.sword_for_offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：用自定义的排序方法进行排序然后依次输出
 */
public class Solution32 {
    public String PrintMinNumber(int [] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = "" + numbers[i];
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                int i = 0;
                int j = 0;
                while (chars1[i] == chars2[j]) {
                    if (chars1[i] == chars2[j]) {
                        if (i == chars1.length - 1 && j == chars2.length - 1) return 0;
                        if (i < chars1.length - 1) i++;
                        if (j < chars2.length - 1) j++;
                    }
                }
                return chars1[i] - chars2[j];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            System.out.println(s);
            sb.append(s);
        }
        return sb.toString();
    }
}
