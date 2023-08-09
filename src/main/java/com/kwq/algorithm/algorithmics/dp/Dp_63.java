package com.kwq.algorithm.algorithmics.dp;

/**
 * @auther : kongweiqiang
 * @DATE : 2021/1/11
 * @DESC : 63.不同路径II: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * @eg :
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Dp_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : Math.min(dp[0][i - 1], 1);
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : Math.min(dp[i - 1][0], 1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Dp_63 main = new Dp_63();
        System.out.println(main.uniquePathsWithObstacles(new int[][]{{0, 1, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}}));
        System.out.println(main.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
}
