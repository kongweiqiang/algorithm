package com.kwq.algorithm.algorithmics.dp;

/**
 * @auther : kongweiqiang
 * @DATE : 2021/1/11
 * @LINK : https://leetcode-cn.com/problems/fibonacci-number/
 * @DESC : 509. 斐波那契数
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 */
public class Dp_509 {

    // 0 1 1 2 3 5
    public int fib(int n) {
        if (n == 0) return n;
        int preAns = 1;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            preAns = ans - preAns;
            ans += preAns;
        }
        return ans;
    }

    public static void main(String[] args) {
        Dp_509 main = new Dp_509();
        System.out.println(main.fib(5));
        System.out.println(main.fib(6));
        System.out.println(main.fib(7));
    }

}
