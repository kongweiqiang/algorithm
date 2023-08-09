package com.kwq.algorithm.algorithmics.dp;

import java.util.ArrayList;
import java.util.List;

public class Dp_100 {

    /**
     * 力扣题目链接：https://leetcode-cn.com/problems/unique-paths-ii
     * <p>
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2 解释：
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 向右 -> 向右 -> 向下 -> 向下
     * 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     * <p>
     * 图片
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     * 提示：
     * <p>
     * m == obstacleGrid.length
     * n == obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     * <p>
     * 0 1 0 0
     * 0 0 0 0
     * 0 1 0 0
     * 0 1 0 0
     * <p>
     * 1 1 1 1 1
     * 0 1 0 0 1
     * 0 0 0 0 1
     * 0 1 1 1 1
     * 0 0 1 1 1
     * 0 1 1 1 1
     */
    public static void main(String[] args) {
        System.out.println(dp(new int[][]{{0, 1, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}}));
    }

    public static int dp(int[][] param) {
        int n = param.length;
        int m = param[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = param[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = param[i][0] == 1 ? 0 : Math.min(1, param[i - 1][0]);
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = param[0][i] == 1 ? 0 : Math.min(1, param[i - 1][0]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = param[i][j] == 1 ? 0 : Math.max(1, dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }
}
