package com.jsj.company.bytedance;

/**
 * 给出 n 个字符串，对于每个 n 个排列 p，按排列给出的顺序(p[0] , p[1] … p[n-1])依次连接这 n 个字符串都能得到一个长度为这些字符串长度之和的字符串。所以按照这个方法一共可以生成 n! 个字符串。
 * <p>
 * 一个字符串的权值等于把这个字符串循环左移 i 次后得到的字符串仍和原字符串全等的数量，i 的取值为 [1 , 字符串长度]。求这些字符串最后生成的 n! 个字符串中权值为 K 的有多少个。
 * <p>
 * 注：定义把一个串循环左移 1 次等价于把这个串的第一个字符移动到最后一个字符的后面。
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为两个正整数 n, K ， n 的大小不超过 8 ， K 不超过 200。接下来有 n 行，每行一个长度不超过 20 且仅包含大写字母的字符串。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数代表权值为 K 的字符串数量。
 * <p>
 * <p>
 * 输入例子1:
 * 3 2
 * AB
 * RAAB
 * RA
 * <p>
 * 输出例子1:
 * 3
 */
public class Solution3 {

    public int find(String[] strings, int num) {
        return doFind(strings, 0, num);
    }

    private int doFind(String[] strings, int start, int num) {
        if (start == strings.length) {
            return check(strings, num) ? 1 : 0;
        }
        int count = 0;
        for (int i = start; i < strings.length; i++) {
            swap(strings, start, i);
            count += doFind(strings, start + 1, num);
            swap(strings, start, i);
        }
        return count;
    }

    private boolean check(String[] strings, int num) {
        int count;
        StringBuilder sb = new StringBuilder();
        return true;
    }

    private void swap(String[] strings, int x, int y) {
        String tmp = strings[x];
        strings[x] = strings[y];
        strings[y] = tmp;
    }
}
