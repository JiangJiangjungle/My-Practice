package com.jsj.leetcode.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 思路：将两次交易独立看待，用一个数组记录第i天以后交易一次获得的最大利润,另一个数组记录第0-i天交易一次获得的最大利润；
 * 那么两次交易的最大利润为：
 * 第0-i天交易一次的最大利润 + 第i天开始交易一次的最大利润；时间复杂度O(n),空间复杂度O(n)
 *
 * @author jsj
 * @date 2019-05-12
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        int[] record1 = new int[prices.length];
        int[] record2 = new int[prices.length];
        int val = 0;
        for (int i = prices.length - 2, max = prices[i + 1]; i >= 0; i--) {
            if (prices[i] >= prices[i + 1]) {
                record1[i] = record1[i + 1];
            } else {
                record1[i] = Math.max(max - prices[i], record1[i + 1]);
            }
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        for (int i = 1, min = prices[0], tmp; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                record2[i] = record2[i - 1];
            } else {
                record2[i] = Math.max(prices[i] - min, record2[i - 1]);
            }
            if (prices[i] < min) {
                min = prices[i];
            }
            tmp = record1[i] + record2[i];
            if (tmp > val) {
                val = tmp;
            }
        }
        return val;
    }
}
