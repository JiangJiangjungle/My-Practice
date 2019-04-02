package com.jsj.company.icbc;

/**
 * 农场有n只鸡鸭排为一个队伍，鸡用“C”表示，鸭用“D”表示。当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡鸭各在一边。每次调整只能让相邻的鸡和鸭交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：CCDCC->CCCDC->CCCCD这样就能使之前的两处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
 * <p>
 * <p>
 * 输入描述:
 * 输入一个长度为N，且只包含C和D的非空字符串。
 * <p>
 * 输出描述:
 * 使得最后仅有一对鸡鸭相邻，最少的交换次数
 * <p>
 * 输入例子1:
 * CCDCC
 * <p>
 * 输出例子1:
 * 2
 */
public class Solution1 {

    public static int find(String s) {
        int toLeft = 0;
        int toRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('C' == s.charAt(i)) {
                toRight += find(s, i + 1, 'D', true);
                toLeft += find(s, i - 1, 'D', false);
            }
        }
        return Math.min(toLeft, toRight);
    }

    private static int find(String s, int start, char d, boolean rightSide) {
        int count = 0;
        if (rightSide) {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(i) == d) {
                    count++;
                }
            }
        } else {
            for (int i = start; i >= 0; i--) {
                if (s.charAt(i) == d) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(find("CCDCDDC"));
    }
}
