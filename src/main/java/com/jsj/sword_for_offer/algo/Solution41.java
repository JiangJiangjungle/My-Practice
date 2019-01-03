package com.jsj.sword_for_offer.algo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输出描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int num = sum - 1; num > 1; num--) {
            doFind(sum, num, list);
        }
        return list;
    }

    private void doFind(int sum, int num, ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> aList;
        int m = sum / num;
        int b = num * (num - 1) / 2;
        int count;
        for (; m > 0; m--) {
            count = num * m + b;
            if (count <= sum) {
                if (count == sum) {
                    aList = new ArrayList<>(num);
                    for (int i = 0; i < num; i++, m++) {
                        aList.add(m);
                    }
                    list.add(aList);
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new Solution41().FindContinuousSequence(100);
        if (list != null) {
            for (ArrayList<Integer> aList : list) {
                System.out.println(Arrays.toString(aList.toArray()));
            }
        }
    }
}
