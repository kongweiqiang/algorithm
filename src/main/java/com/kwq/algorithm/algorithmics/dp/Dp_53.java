package com.kwq.algorithm.algorithmics.dp;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/23
 * @DESC : No.53
 *         给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Dp_53 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int [] dp = new int [nums.length];
        int index = 0;
        int sum = 0;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = sum(nums, index, i);
            if(nums[i] >= sum && nums[i] > 0){
                index = i;
            }
            dp[i] = Math.max(Math.max(dp[i-1],nums[i]),sum);
        }
        return dp[nums.length - 1];
    }

    private int sum(int [] nums,int start,int end){
        if(start >= end || end >= nums.length) return start == end ? nums[start] : 0;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Dp_53 main = new Dp_53();
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(main.maxSubArray(nums1));
        int[] nums2 = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(main.maxSubArray(nums2));
    }


}
