package com.jsj.company;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(str);
            String[] strs = str.split(" ");
            System.out.println(Arrays.toString(strs));
        }
    }
}
