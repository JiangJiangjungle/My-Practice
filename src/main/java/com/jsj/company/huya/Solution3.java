package com.jsj.company.huya;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        print(21);

        File file = new File("D:\\project-personal\\SecKill-System\\app\\src\\main\\resources\\test_data.dat");
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
        for (int i = 1; i <= 10000; i++) {
            outputStream.write((1 + "," + i + "\r\n").getBytes());
        }
        outputStream.flush();
        outputStream.close();
    }

    public static void print(int n) {
        for (int i = 0, j = n; j >= 1; i++, j -= 2) {
            for (int x = 0; x < i; x++) {
                System.out.print(" ");
            }
            for (int x = 0; x < j; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
