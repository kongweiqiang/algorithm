package com.kwq.algorithm.algorithmics.dp;

/**
 * 马走棋盘
 *
 * @auther : kongweiqiang
 * @DATE : 2021/1/7
 * @DESC : 在棋盘上处于[0,0]位置的马需要k步刚好走到[a,b]位置的走法总数
 */
public class Dp_Z_2 {

    /**
     * 求当前处于[x,y]位置的单位(马)还剩下k步可走,走完k步,正好达到[a,b]位置的方法数
     *
     * @param x 起点
     * @param y 起点
     * @param a 终点
     * @param b 终点
     * @param k 剩余步数
     * @return 总方法数
     */
    public static int jump(int x, int y, int a, int b, int k) {
        //illegal case 9X10的格子是可走范围
        if (x < 0 || x > 9 || y < 0 || y > 10) return 0;
        //base case
        if (k == 0) return x == a && y == b ? 1 : 0;
        //马走日
        return jump(x + 2, y + 1, k - 1, a, b) +
                jump(x + 2, y - 1, k - 1, a, b) +
                jump(x - 2, y + 1, k - 1, a, b) +
                jump(x - 2, y - 1, k - 1, a, b) +
                jump(x + 1, y + 2, k - 1, a, b) +
                jump(x + 1, y - 2, k - 1, a, b) +
                jump(x - 1, y + 2, k - 1, a, b) +
                jump(x - 1, y + 2, k - 1, a, b);
    }

    /**
     * @param a 终点
     * @param b 终点
     * @param k 剩余步数
     * @return
     */
    public static int f(int a, int b, int k) {
        int[][][] dp = new int[10][9][k + 1];
        dp[a][b][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 9; y++) {
                    dp[x][y][rest] =
                            wrap(dp, x + 2, y + 1, k - 1) +
                            wrap(dp, x + 2, y - 1, k - 1) +
                            wrap(dp, x - 2, y + 1, k - 1) +
                            wrap(dp, x - 2, y - 1, k - 1) +
                            wrap(dp, x + 1, y + 2, k - 1) +
                            wrap(dp, x + 1, y - 2, k - 1) +
                            wrap(dp, x - 1, y + 2, k - 1) +
                            wrap(dp, x - 1, y + 2, k - 1);
                }
            }
        }
        return dp[a][b][0];
    }

    private static int wrap(int[][][] dp, int x, int y, int k) {
        if (x < 0 || x > 9 || y < 0 || y > 10) return 0;
        return dp[x][y][k];
    }
}
