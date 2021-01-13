package com.kwq.algorithm.algorithmics.dp;

/**
 * @auther : kongweiqiang
 * @DATE : 2021/1/11
 * @DESC : 746.使用最小花费爬楼梯
 * @LINK : https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class Dp_746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) return 0;
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    public static void main(String[] args) {
        Dp_746 main = new Dp_746();
        System.out.println(main.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(main.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
