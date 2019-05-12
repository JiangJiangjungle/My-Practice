package com.jsj.leetcode.dp;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * <p>
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 * <p>
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * <p>
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2:
 * <p>
 * 输入: S = "babgbag", T = "bag"
 * 输出: 5
 * 解释:
 * <p>
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * <p>
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 * <p>
 * 思路：1.用递归做，获得numDistinct(s.substring(1), t)结果。
 * 若S首字符与T首字符相等，结果再加上numDistinct(s.substring(1), t.substring(1))。
 * 此方法时间复杂度较高；
 * 2.用迭代做，即利用二维数组做作为字典。
 *
 * @author jsj
 * @date 2019-05-12
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        if (s == null && t == null) return 1;
        if (s == null || t == null) return 0;
        if (s.equals(t)) {
            return 1;
        } else if (s.length() <= t.length()) {
            return 0;
        }
        int[][] record = new int[s.length()][t.length()];
        record[s.length() - 1][t.length() - 1] = s.charAt(s.length() - 1) == t.charAt(t.length() - 1) ? 1 : 0;
        for (int j = t.length() - 1; j >= 0; j--) {
            for (int i = s.length() - 2; i >= j; i--) {
                record[i][j] += record[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    record[i][j] += j < t.length() - 1 ? record[i + 1][j + 1] : 1;
                }
            }
        }
        return record[0][0];
    }

    public int numDistinct2(String s, String t) {
        if (s == null && t == null) return 1;
        if (s == null || t == null) return 0;
        if (s.equals(t)) {
            return 1;
        } else if (s.length() <= t.length()) {
            return 0;
        }
        //当字符串t长度只有1时，直接遍历
        if (t.length() == 1) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(0)) {
                    count++;
                }
            }
            return count;
        }
        int val = numDistinct(s.substring(1), t);
        if (s.charAt(0) == t.charAt(0)) {
            val += numDistinct(s.substring(1), t.substring(1));
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution115().numDistinct("babgbag", "bag"));
    }
}
