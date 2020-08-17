package com.kwq.algorithm.algorithmics.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/7/22
 * @DESC : 递归
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //Integer[] result = solution.divingBoard(1, 2, 3);
        //System.out.println(result);
        //System.out.println(solution.kthGrammar(5, 4));//1
        System.out.println(solution.myPow(0.00001d,10));
        System.out.println(solution.myPow(2.000d,-2));
        solution.divingBoard(1,2,4);
    }

    /** 跳水板
     * 有两种类型的木板，较短的长度为shorter，较长的长度为longer。你必须正好使用k块木板，生成跳水板所有可能的长度
     * @number 16.11
     * @desc shorter = 1  longer = 2  k = 3  ----> 所有可能:[3,4,5,6]
     * @param shorter 短板长度
     * @param longer 长板长度
     * @param k 正好使用的木板数
     * @return 所有可能的使用木板数集
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        Set<Integer> set = new TreeSet<>();
        Set<Integer> diving = diving(shorter, longer, k, set);
        return diving.stream().mapToInt(Integer::intValue).toArray();
    }

    private Set<Integer> diving(int shorter, int longer, int k,Set<Integer> set){
        if(k <= 0) return set;
        if(k == 1){
            set.add(shorter);
            set.add(longer);
            return set;
        }
        for (int i = 0; i < k; i++) {
            set.add(shorter*i + (k-i)*longer);
        }
        return set;
    }

    /** 779. 第K个语法符号
     * @desc 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
     *       给定行数 N 和序数 K，返回第 N 行中第 K个字符。(K从1开始)
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar(int n, int k) {
        return kth(n,k,0);
    }

    public int kth(int n,int k,int bool){
        if(n <=1 ){
            return bool;
        }
        int half = 1 << n-2;
        if(k<=half){
            return kth(n-1, k,bool);
        }
        return kth(n-1, k-half,1-bool);
    }


    /**
     * @number 698. 划分为k个相等的子集
     * @desc 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等
     * @param nums
     * @param k
     * @eg  输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     *      输出： True
     *      说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[nums.length-1] > k){
            return false;
        }
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        int n = sum/k;
        if (Math.floorMod(sum,k) != 0) {
            return false;
        }
        //计算
        return true;
    }

    /**
     * 面试题 08.05. 递归乘法:实现两个正整数相乘
     * @param a
     * @param b
     * @return
     */
    public int multiply(int a, int b) {
        //保证a始终是最小的数,降低递归深度
        if(a>b){
            a = a^b;
            b = a^b;
            a = a^b;
        }
        if (a == 1) {
            return b;
        }
        return b+multiply(a-1,b);
    }

    public double myPow(double x, int n) {
        if(n==0){
            return 1.0d;
        }
        double v = myPowHelp(x, n);
        return n<0? 1/v:v;
    }

    public double myPowHelp(double x, int n) {
        if(n<0){
            n = -n;
        }
        if(n==1){
            return x;
        }
        return x*myPowHelp(x,n-1);
    }

    /** @number 剑指 Offer 10- II. 青蛙跳台阶问题 && 70. 爬楼梯
     * @desc 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
     */
    private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    private int mod = 1000000007;
    public int numWays(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(!map.isEmpty() && map.containsKey(n)){
            return map.get(n);
        }
        int sum = Math.floorMod(numWays(n - 1) + numWays(n - 2),mod);
        map.put(n,sum);
        return sum;
    }

}
