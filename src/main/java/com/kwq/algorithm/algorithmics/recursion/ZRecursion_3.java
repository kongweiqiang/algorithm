package com.kwq.algorithm.algorithmics.recursion;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/31
 * @DESC : 小人走路
 * @eg : 1234567 起始位置为2,目标位置为4,给k==4步,问总共有多少种方法
 */
public class ZRecursion_3 {


    /** 小人走路
     * @method 方法一 递归
     * @param cur 当前位置
     * @param rest 还剩下可移动的步数(每步移动一单位偏移量)
     * @param aim 目标位置
     * @param n 总步数
     * @return
     */
    public static int process(int cur,int rest,int aim,int n){
        if(cur <=0 || rest < 0 || cur > n) return 0;
        if(rest == 0 && cur == aim) return 1;
        return process(cur + 1,rest - 1, aim,n) + process(cur - 1,rest - 1, aim,n);
    }

    /** 小人走路
     * @method 方法一 动态规划 : 表示在cur位置上,剩下rest可以走,能走到目标位置的方法数
     * @param cur 当前位置
     * @param rest 还剩下可移动的步数(每步移动一单位偏移量)
     * @param aim 目标位置
     * @param n 总步数
     * @return 总方法 步数
     */
    public static int dp(int cur,int rest,int aim,int n){
        int [][] dp = new int [rest + 1][n + 1];
        dp[aim][1] = 1;//cur==aim:当前位置在目标位置上,rest==0:没有可移动步数,即走完了刚好移动到目标位置上,认为找到了一种走法
        for (int i = 1; i < n; i++) {//列
            for (int j = 1; j < aim; j++) {//行
                dp[i][j]  = dp[i - 1][j - 1] + (i + 1) >= n ? 0 :dp[i + 1][j - 1];

                System.out.println(dp[i][j]);
            }
        }
        return dp[cur][aim];
    }

    public static void main(String[] args) {
        int k = 4;
        System.out.println(process(2,k,4,k));
        System.out.println(dp(2,k,4,k));
    }
}
