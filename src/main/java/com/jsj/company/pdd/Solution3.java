package com.jsj.company.pdd;

import java.util.*;

/**
 * A 国的手机号码由且仅由 N 位十进制数字(0-9)组成。一个手机号码中有至少 K 位数字相同则被定义为靓号。
 * A 国的手机号可以有前导零，比如 000123456 是一个合法的手机号。
 * 小多想花钱将自己的手机号码修改为一个靓号。
 * 修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值。比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
 * 给出小多现在的手机号码，问将其修改成一个靓号，最少需要多少钱？
 * <p>
 * 思路：遍历0-9每一个数字，计算每一个数字出现k次时候的最小花费:从左到右找大于i的最近数字，变成i;从右到左找小于i的最近数字，变成i
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int k = Integer.parseInt(str.split(" ")[1]);

        //字符串
        char[] ori = in.nextLine().toCharArray();
        //每个字符出现次数
        int[] count = new int[10];
        for (char i : ori) {
            count[i - '0']++;
        }
        //最小花费
        int mod = Integer.MAX_VALUE;
        //修改后的字符串
        char[] res = new char[n];
        for (int i = 0; i < 10; ++i) {
            int tmpK = k - count[i];
            if (tmpK <= 0) {
                mod = 0;
                res = ori;
                break;
            }
            char[] tmpArr = Arrays.copyOf(ori, ori.length);
            int tmpMod = 0;
            int l = i - 1;
            int r = i + 1;
            while (tmpK > 0) {
                //从左到右找大于i的最近数字，变成i
                if (r < 10) {
                    for (int v = 0; v < n && tmpK > 0; v++) {
                        if (tmpArr[v] - '0' == r) {
                            tmpMod += r - i;
                            tmpArr[v] = (char) ('0' + i);
                            tmpK--;
                        }
                    }
                }
                //从右到左找小于i的最近数字，变成i
                if (l >= 0) {
                    for (int v = n - 1; v >= 0 && tmpK > 0; --v) {
                        if (tmpArr[v] - '0' == l) {
                            tmpMod += i - l;
                            tmpArr[v] = (char) ('0' + i);
                            tmpK--;
                        }
                    }
                }
                l--;
                r++;
            }
            if (tmpMod < mod) {
                mod = tmpMod;
                res = tmpArr;
            }

        }

        System.out.println(mod);
        System.out.println(new String(res));
    }
}
