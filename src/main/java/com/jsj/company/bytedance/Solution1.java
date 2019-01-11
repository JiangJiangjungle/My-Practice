package com.jsj.company.bytedance;

import java.util.Scanner;

/**
 * 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。 n 不大于 50，且至少存在一个字符不是任何字符串的首字母。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个数，表示最大和是多少。
 * <p>
 * <p>
 * 输入例子1:
 * 2
 * ABC
 * BCA
 * <p>
 * 输出例子1:
 * 1875
 */
public class Solution1 {

    public int value = 0;

    public int find(String[] strings) {
        int[] records = new int[10];
        for (int i = 0; i < records.length; i++) {
            records[i] = i;
        }
        int maxLength = 0;
        for (int x = 0; x < strings.length; x++) {
            if (maxLength < strings[x].length()) {
                maxLength = strings[x].length();
            }
        }
        swapAndTry(records, 0, strings, maxLength);
        int result = value;
        value = 0;
        return result;
    }

    private void swapAndTry(int[] records, int start, String[] strings, int maxLength) {
        if (start == records.length) {
            int v = transForm(strings, maxLength, records);
            if (v > value) {
                value = v;
            }
            return;
        }
        for (int i = start; i < records.length; i++) {
            swap(records, start, i);
            swapAndTry(records, start + 1, strings, maxLength);
            swap(records, start, i);
        }
    }

    private void swap(int[] records, int x, int y) {
        int tmp = records[x];
        records[x] = records[y];
        records[y] = tmp;
    }

    private int transForm(String[] strings, int maxLength, int[] records) {
        int result = 0;
        int now;
        for (int i = 1; i <= maxLength; i++) {
            now = 0;
            for (int x = 0; x < strings.length; x++) {
                if (strings[x].length() < i) {
                    continue;
                }
                now += records[strings[x].charAt(strings[x].length() - i) - 'A'];
            }
            result += now * Math.pow(10, i - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Scanner scanner = new Scanner(System.in);
        int num;
        String[] strings;
        while (scanner.hasNext()) {
            num = Integer.parseInt(scanner.nextLine());
            strings = new String[num];
            for (int i = 0; i < num; i++) {
                strings[i] = scanner.nextLine();
            }
            System.out.println(solution1.find(strings));
        }
    }
}
