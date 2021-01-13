package com.kwq.algorithm.algorithmics.dp;

/**
 * @auther : kongweiqiang
 * @DATE : 2021/1/11
 * @DESC : 70.爬楼梯
 */
public class Dp_70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsII(int n) {
        int first = 0;
        int second = 1;
        int ans = second;
        for (int i = 2; i <= n; i++) {
            first = second;
            second = ans;
            ans = first + second;
        }
        return ans;
    }
}
