package com.jsj.nowcode;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Solution51 {
    public int[] multiply(int[] A) {
        int length = A.length;

        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * A[i - 1];
        }
        int c = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= c;
            c *= A[i];
        }
        return result;
    }
}
