package com.jsj.leetcode;

import java.util.Comparator;
import java.util.List;

/**
 * @author jsj
 * @since 2018-12-20
 * 题目描述：给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Solution57 {
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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        intervals.sort(Comparator.comparingInt(o -> o.start));
        Interval now;
        Interval last;
        for (int i = 1; i < intervals.size(); ) {
            now = intervals.get(i);
            last = intervals.get(i - 1);
            if (merge(now, last)) {
                intervals.remove(i);
            } else {
                i++;
            }
        }
        return intervals;
    }

    private boolean merge(Interval now, Interval last) {
        if (now.start <= last.end) {
            last.end = last.end > now.end ? last.end : now.end;
            return true;
        }
        return false;
    }
}
