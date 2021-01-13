package com.kwq.algorithm.algorithmics.dp;

/**
 * @auther : kongweiqiang
 * @DATE : 2021/1/7
 * @DESC : 最长回文子序列长度
 * @idea:
 *          1.一个串和它逆序串的最长公共子序列就是它的最长回文子序列
 *          2.f函数代表s字符串在[l,r]上的最长回文子序列的长度
 */
public class Dp_Z_1 {

    /** 递归
     * @idea f函数代表最长回文子序列的长度
     * @param s 串
     * @param l leftIndex
     * @param r rightIndex
     * @return 最长回文子序列的长度
     * @switch 场景分析: 范围尝试模型: 讨论"开头"和"结尾"的可能性
     *      1.不以l开头,不以r结尾
     *      2.以l开头,不以r结尾
     *      3.不以l开头,以r结尾
     *      4.以l开头,以r结尾
     */
    public static int f(String s,int l,int r){
        if(s == null || s.length() == 0 ||r < l){
            return 0;
        }
        if(r == l) return 1;
        if(l == r - 1) return s.charAt(l) == s.charAt(r) ? 1 : 0;
        //1.不以l开头,不以r结尾
        int p1 = f(s,l + 1,r + 1);
        //2.以l开头,不以r结尾
        int p2 = f(s,l,r + 1);
        //3.不以l开头,以r结尾
        int p3 = f(s,l + 1,r);
        //以l开头,以r结尾
        int p4 = s.charAt(l) == s.charAt(r) ? (f(s,l + 1, r - 1) + 2) : 0;
        return Math.max(Math.max(p1,p2),Math.max(p3,p4));
    }

    /**
     * s在[l,r]上最长回文子序列的长度
     * @idea 当l > r 时,无意义,dp表最终有效的只有半张表,最终求的答案是s在[0,len]上的值
     * @param s 串
     * @param l 左边界索引值
     * @param r 由边界索引值
     * @return
     */
    public static int dp(String s,int l,int r){
        if(s == null || s.length() == 0 ||r < l){
            return 0;
        }
        if(r == l) return 1;
        int len = s.length();
        int [][] dp = new int[len][len];
        //初始化
        //填写第一个数
        dp[len - 1][len - 1] = 1;
        for (int i = 0; i < len - 1; i++) {
            //填写第一条对角线
            dp[i][i] = 1;
            //填写第二条对角线
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
        }
        //从第三条对角线开始转移
        for (l = len - 3; l > 0; l--) {
            for (r = len; r > l; r--) {
             /* //1.不以l开头,不以r结尾
                int p1 = dp[l + 1][r + 1];
                //2.以l开头,不以r结尾
                int p2 = dp[l][r + 1];
                //3.不以l开头,以r结尾
                int p3 = dp[l + 1][r];
                //以l开头,以r结尾
                int p4 = s.charAt(l) == s.charAt(r) ? (dp[l + 1][ r - 1] + 2) : 0;
                dp[l][r] = Math.max(Math.max(p1,p2),Math.max(p3,p4));
             */
                //依赖状态转移,第一种情况可省略
                dp[l][r] = Math.max(dp[l][r + 1],dp[l +1][r]);
                if(s.charAt(l) == s.charAt(r)){
                    dp[l][r] = Math.max(dp[l][r],dp[l + 1][ r - 1] + 2);
                }
            }
        }
        return dp[0][len - 1];
    }

}
