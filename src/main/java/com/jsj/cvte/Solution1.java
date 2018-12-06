package com.jsj.cvte;

/**
 * 相邻数组配对
 */
public class Solution1 {

    public int get(int[] row) {
        int[] length = getLength(row);
        int count = 0;
        while (!check(length)) {
            swap(length);
            count++;
        }
        return count;
    }

    private boolean check(int[] length) {
        for (int aLength : length) {
            if (aLength != 0) return false;
        }
        return true;
    }

    private int[] getLength(int[] number) {
        int[] length = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                for (int j = 0; j < number.length; j++) {
                    if (number[j] == number[i] + 1) {
                        length[i] = j>i?j-i-1:j-i+1;
                        length[j] = j>i?i-j+1:i-j-1;
                    }
                }
            }
        }
        return length;
    }

    private void swap(int[] length) {
        for (int i = 0; i < length.length - 1; i++) {
            if (length[i] > 0 && length[i + 1] < 0) {
                length[i + length[i]+1]++;
                length[i + 1 + length[i + 1]-1]--;
                length[i + 1]++;
                length[i]--;
                //swap
                length[i] = length[i] + length[i + 1];
                length[i + 1] = length[i] - length[i + 1];
                length[i] = length[i] - length[i + 1];
                break;
            } else if (length[i] > 0 && length[i + 1] == 0) {
                length[i + length[i]+1]++;
                length[i + 2]--;
                length[i + 1]++;
                length[i]--;
                //swap
                length[i] = length[i] + length[i + 1];
                length[i + 1] = length[i] - length[i + 1];
                length[i] = length[i] - length[i + 1];
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().get(new int[]{0,7,1,4,3,5,6,2}));
    }
}
