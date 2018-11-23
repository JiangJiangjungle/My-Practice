package main.java.com.jsj.sword_for_offer;

import java.util.ArrayList;

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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> now;
        if (sum % 2 == 0) {
            for (int i = (int) Math.sqrt(sum * 2); i >= 2; i--) {
                if ((i % 2 == 0 && (sum % i == i / 2)) || (i % 2 != 0 && (sum % i == 0))) {
                    now = doCreate(i, sum / i);
                    result.add(now);
                }
            }
        } else {
            for (int i = (int) Math.sqrt(sum * 2); i >= 2; i--) {
                if (i % 2 != 0 && (sum % i == 0)) {
                    now = doCreate(i, sum / i);
                    result.add(now);
                } else if (i % 2 == 0 && i % 4 != 0 && (sum % i == i / 2)) {
                    now = doCreate(i, sum / i);
                    result.add(now);
                }
            }
        }
        return result;
    }


    private static ArrayList<Integer> doCreate(int i, int num) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int x = 0; x < i; x++) {
            if (i % 2 == 0) {
                result.add(num - i / 2 + x + 1);
            } else {
                result.add(num - i / 2 + x);
            }
        }

        return result;
    }
}
