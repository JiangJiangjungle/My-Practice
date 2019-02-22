package com.jsj.leetcode.others;

import java.util.*;

/**
 * @author jsj
 * @since 2018-12-19
 * 题目描述：给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution56 {
    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new LinkedList<>(intervals);
        list.sort(Comparator.comparingInt(o -> o.start));
        Interval now;
        Interval last;
        for (int i = 1; i < list.size(); ) {
            now = list.get(i);
            last = list.get(i - 1);
            if (merge(now, last)) {
                list.remove(i);
            } else {
                i++;
            }
        }
        return list;
    }

    private boolean merge(Interval now, Interval last) {
        if (now.start <= last.end) {
            last.end = last.end > now.end ? last.end : now.end;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        list = new Solution56().merge(list);
        if (null != list) {
            for (Interval i : list) {
                System.out.println(i.start + ", " + i.end);
            }
        }
    }
}
