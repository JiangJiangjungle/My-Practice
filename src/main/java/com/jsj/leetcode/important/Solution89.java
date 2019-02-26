package com.jsj.leetcode.important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 * 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 * 因此，当 n = 0 时，其格雷编码序列为 [0]。
 * <p>
 * 思路：第一个码：000^000=000 ；第二个码：001^000 = 001；第三个码：010^001=011；第四个码：011^001=010以此类推
 */
public class Solution89 {
    public List<Integer> grayCode(int n) {
        int len = 1 << n;
        List<Integer> ret = new ArrayList<>(len);
        for (int i = 0; i < len; ++i) {
            ret.add(i ^ i >> 1);
        }
        return ret;
    }


    public static void main(String[] args) {
        List<Integer> list = new Solution89().grayCode(3);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
