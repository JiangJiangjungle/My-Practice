package com.jsj.leetcode.dp;

import java.util.Arrays;

/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，
 * 他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），
 * 要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 *  
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * 思路：
 *
 * @author jsj
 * @date 2019-06-23
 */
public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] record = new int[dungeon.length][dungeon[0].length];
        for (int i = 0; i < record.length; i++) {
            Arrays.fill(record[i], Integer.MAX_VALUE);
        }
        return calculateMinimumHP(dungeon, 0, 0, record);
    }

    private int calculateMinimumHP(int[][] dungeon, int x, int y, int[][] record) {
        if (record[x][y] != Integer.MAX_VALUE) {
            return record[x][y];
        }
        if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
            record[x][y] = dungeon[x][y] > 0 ? 1 : 1 - dungeon[x][y];
            return record[x][y];
        }
        if (x == dungeon.length - 1) {
            record[x][y] = calculateMinimumHP(dungeon, x, y + 1, record) - dungeon[x][y];
        } else if (y == dungeon[0].length - 1) {
            record[x][y] = calculateMinimumHP(dungeon, x + 1, y, record) - dungeon[x][y];
        } else {
            record[x][y] = Math.min(calculateMinimumHP(dungeon, x + 1, y, record), calculateMinimumHP(dungeon, x, y + 1, record)) - dungeon[x][y];
        }
        if (record[x][y] < 1) {
            record[x][y] = 1;
        }
        return record[x][y];
    }
}
