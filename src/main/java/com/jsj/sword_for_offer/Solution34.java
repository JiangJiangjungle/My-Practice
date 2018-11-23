package main.java.com.jsj.sword_for_offer;

import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * <p>
 * 思路:用两个大小为52（大小写字母长度）数组分别维护出现次数和最后出现位置。
 */
public class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        int[] count = new int[52];
        int[] loc = new int[52];
        Arrays.fill(loc, -1);
        char[] chars = str.toCharArray();
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] > 'Z' ? chars[i] - 'a' + 26 : chars[i] - 'A';
            count[index] += 1;
            if (loc[index] == -1) {
                loc[index] = i;
            }
        }
        int firstLoc = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1 && (loc[i] < firstLoc || firstLoc == -1)) {
                firstLoc = loc[i];
            }
        }
        return firstLoc;
    }
}
