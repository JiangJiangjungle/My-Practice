package com.jsj.company.pdd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 你在玩一个回合制角色扮演的游戏。现在你在准备一个策略，以便在最短的回合内击败敌方角色。
 * 在战斗开始时，敌人拥有HP格血量。当血量小于等于0时，敌人死去。一个缺乏经验的玩家可能简单地尝试每个回合都攻击。但是你知道辅助技能的重要性。
 * 在你的每个回合开始时你可以选择以下两个动作之一：聚力或者攻击。
 * 聚力会提高你下个回合攻击的伤害。
 * 攻击会对敌人造成一定量的伤害。如果你上个回合使用了聚力，那这次攻击会对敌人造成buffedAttack点伤害。否则，会造成normalAttack点伤害。
 * 给出血量HP和不同攻击的伤害，buffedAttack和normalAttack，返回你能杀死敌人的最小回合数。
 * <p>
 * 第一行是一个数字HP
 * 第二行是一个数字normalAttack
 * 第三行是一个数字buffedAttack
 * 1 <= HP,buffedAttack,normalAttack <= 10^9
 */
public class Solution6 {
    public static Map<Long, Integer> cache = new HashMap<>();

    private static int func(long hp, long normal, long buff) {
        if (hp <= 0) return 0;
        if (cache.get(hp) != null) return cache.get(hp);
        cache.put(hp, 1 + Math.min(func(hp - normal, buff, normal), 1 + func(hp - buff - normal, buff, normal)));
        return cache.get(hp);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long hp = Long.parseLong(in.nextLine());
        long normal = Long.parseLong(in.nextLine());
        long buff = Long.parseLong(in.nextLine());
        cache.clear();
        System.out.println(func(hp, normal, buff));
    }

    public static int[] trans(String[] strArray) {
        int[] nums = new int[strArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }
        return nums;
    }
}
