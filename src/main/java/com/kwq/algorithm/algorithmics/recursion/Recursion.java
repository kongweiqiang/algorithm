package com.kwq.algorithm.algorithmics.recursion;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(f(5));
        System.out.println(dp(5));
        System.out.println(f(4));
        System.out.println(dp(4));
        System.out.println(f(3));
        System.out.println(dp(3));
        System.out.println(f(2));
        System.out.println(dp(2));
    }

    public static int f(int x) {
        if (x <= 0) return -1;
        if (x == 1) return 1;
        if (x == 2) return 1;
        return f(x - 1) + f(x - 2);
    }


    public static int dp(int x) {
        if (x <= 0) return -1;
        int dp[] = new int[x];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[x - 1];
    }
}
