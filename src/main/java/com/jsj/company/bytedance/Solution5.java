package com.jsj.company.bytedance;

import java.util.Scanner;

/**
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 * <p>
 * 输入描述:
 * 第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
 * <p>
 * 后面跟随N行，每行为一个待校验的字符串。
 * <p>
 * 输出描述:
 * N行，每行包括一个被修复后的字符串。
 * <p>
 * 输入例子1:
 * 2
 * helloo
 * wooooooow
 * <p>
 * 输出例子1:
 * hello
 * woow
 */
public class Solution5 {
    public static String[] output(int len, String[] words) {
        String[] out = new String[len];
        for (int i = 0; i < words.length; i++) {
            out[i] = repair(words[i]);
        }
        return out;
    }

    private static String repair(String word) {
        if (word.length() < 4) return word;
        char[] tmp = new char[4];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (; index < 2; index++) {
            tmp[index] = word.charAt(index);
            sb.append(tmp[index]);
        }
        for (int i = 2; i < word.length(); i++) {
            boolean repeat = tmp[(index +3) % 4] == word.charAt(i)
                    && (tmp[(index +3) % 4] == tmp[(index +2) % 4] || tmp[(index + 1) % 4] == tmp[(index + 2) % 4]);
            if (repeat) continue;
            tmp[index] = word.charAt(i);
            sb.append(word.charAt(i));
            index = (index + 1) % 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = Integer.parseInt(scanner.nextLine());
            String[] words = new String[len];
            for (int i = 0; i < len; i++) {
                words[i] = scanner.nextLine();
            }
            String[] output = output(len, words);
            for (String str : output) {
                System.out.println(str);
            }
        }
    }
}
