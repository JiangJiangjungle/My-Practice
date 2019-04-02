package com.jsj.company.huya;

/**
 * 2019-03-26
 */
public class Solution1 {
    public static void main(String[] args) throws Exception {
        System.out.println(compare("1.12", "13.13"));
    }

    public static int compare(String v1, String v2) {
        String[] ss1 = v1.split("[.]");
        String[] ss2 = v2.split("[.]");
        for (int i = 0, j = 0, tmp1, tmp2; i < ss1.length || j < ss2.length; i++, j++) {
            if (i == ss1.length) {
                return -1;
            }
            if (j == ss2.length) {
                return 1;
            }
            tmp1 = Integer.parseInt(ss1[i]);
            tmp2 = Integer.parseInt(ss2[j]);
            if (tmp1 < tmp2) {
                return -1;
            } else if (tmp1 > tmp2) {
                return 1;
            }
        }
        return 0;
    }
}
