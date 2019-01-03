package com.jsj.sword_for_offer.array;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution6 {
    public int minNumberInRotateArray(int[] array) {
        int mid;
        for (int low = 0, high = array.length - 1; low <= high; ) {
            if (low == high) return array[low];
            mid = (low + high) / 2;
            if (array[mid] >= array[0]) {
                low = mid + 1;
            } else if (array[mid] >= array[mid - 1]) {
                high = mid - 1;
            } else {
                return array[mid];
            }
        }
        return 0;
    }
}
