package main.java.com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：统计一个数字在排序数组中出现的次数。
 * <p>
 * 思路：二分查找
 */
public class Solution37 {
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) return 0;
        int minValue = array[0];
        int maxValue = array[array.length - 1];
        if (k < minValue) return 0;
        if (k > maxValue) return 0;
        int low = 0;
        int high = array.length - 1;
        int now;
        while (low <= high) {
            now = (low + high) / 2;
            if (array[now] == k) {
                //找到k在array（从low 到high中） 的上下界
                int[] range = findRange(array, low, high, now, k);
                System.out.println(range[0] + " " + range[1]);
                return range[1] - range[0] + 1;
            } else if (array[now] < k) {
                low = low + 1;
            } else {
                high = high - 1;
            }
        }
        return 0;
    }

    private int[] findRange(int[] array, int low, int high, int now, int k) {
        int[] range = new int[2];
        int mid = now;
        int temp;
        while (low <= mid) {
            if (low == mid) {
                range[0] = low;
                break;
            }
            temp = (low + mid) / 2;
            if (array[temp] == k) {
                if (temp == low || array[temp - 1] != k) {
                    range[0] = temp;
                    break;
                }
                mid = temp - 1;
            } else {
                if (array[temp + 1] == k) {
                    range[0] = temp + 1;
                    break;
                }
                low = temp;
            }
        }
        mid = now;
        while (mid <= high) {
            if (mid == high) {
                range[1] = high;
                break;
            }
            temp = (mid + high) / 2;
            if (array[temp] == k) {
                if (temp == high || array[temp + 1] != k) {
                    range[1] = temp;
                    break;
                }
                mid = temp + 1;
            } else {
                if (array[temp - 1] == k) {
                    range[1] = temp - 1;
                    break;
                }
                high = temp;
            }
        }
        return range;
    }
}
