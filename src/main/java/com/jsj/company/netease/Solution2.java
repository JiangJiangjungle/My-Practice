package com.jsj.company.netease;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution2 {
    public static String find(String s) {
        Deque<Character> deque = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            deque.offerLast(s.charAt(i));
        }
        return doFind(deque);
    }

    private static String doFind(Deque<Character> deque) {
        char[] chars = new char[deque.size()];
        for (int i = 0, now = 0; now < chars.length; i = 0, now++) {
            for (int size = chars.length - now; size < chars.length; i++, size++) {
                i = (i + 1) % size;
                if (size % 2 == 0) {
                    i = size - 1 - i;
                }
            }
            chars[i] = deque.pollFirst();
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println(find(str));
        }
    }
}
