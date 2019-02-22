package com.jsj.company.icbc;

import java.util.Scanner;

/**
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * <p>
 * 输入描述:
 * 输入正整数N
 * <p>
 * 输出描述:
 * 输出1到N中好数个数
 * <p>
 * 输入例子1:
 * 10
 * <p>
 * 输出例子1:
 * 4
 * <p>
 * 例子说明1:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 */
public class Solution4 {

    public static int count(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (good(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean good(int num) {
        boolean travel = false;
        for (int tmp = num; tmp != 0; tmp /= 10) {
            int i = tmp % 10;
            if (i == 2 || i == 5 || i == 6 || i == 9) {
                travel = true;
            } else if (!(i == 0 || i == 1 || i == 8)) {
                return false;
            }
        }
        return travel;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(count(n));
        }
    }

}
