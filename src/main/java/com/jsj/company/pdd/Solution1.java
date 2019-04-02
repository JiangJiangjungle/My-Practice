package com.jsj.company.pdd;

import java.util.*;

/**
 * 2019-03-10
 */
public class Solution1 {

    public static char getChar(char[] chars) {
        Map<Character, Integer> record = new HashMap<>();
        int minIndex = chars.length - 1;
        char min = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = Character.toLowerCase(chars[i]);
            if (record.containsKey(ch)) {
                record.put(ch, record.get(ch) + 1);
            } else {
                record.put(ch, 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = Character.toLowerCase(chars[i]);
            if (record.get(ch) == 1) {
                minIndex = i;
                min = ch;
                break;
            }
        }
        for (int i = 0; i <= minIndex; i++) {
            char ch = Character.toLowerCase(chars[i]);
            if (min == 0 || ch < min) {
                minIndex = i;
                min = ch;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(getChar(str.toCharArray()));
        }
    }
}
