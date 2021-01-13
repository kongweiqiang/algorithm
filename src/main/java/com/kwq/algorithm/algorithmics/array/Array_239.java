package com.kwq.algorithm.algorithmics.array;

import java.util.Arrays;

/**
 * @auther : kongweiqiang
 * @DATE : 2021/1/8
 * @DESC : 239. 滑动窗口最大值: 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值
 */
public class Array_239 {

    /**
     * @param nums 数组
     * @param k    滑动窗口大小
     * @return 滑动窗口最大值组成的数组
     * @number 239
     * @desc 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
     * @eg 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int left = 0, index = 0, len = nums.length;
        int right = len >= k ? k - 1 : len;
        int[] result = new int[len];
        while (right < len) {
            result[index++] = max(nums, left++, right++);
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    private int max(int[] nums, int left, int right) {
        int first = nums[left];
        while (left <= right) {
            first = first > nums[left] ? first : nums[left];
            left++;
        }
        return first;
    }

    public void f(int i){
        System.out.println(i);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] nums2 = {1};
        int k2 = 1;
        int[] nums3 = {9, 11};
        int k3 = 2;
        Array_239 main = new Array_239();
        int[] result1 = main.maxSlidingWindow(nums1, k1);
        int[] result2 = main.maxSlidingWindow(nums2, k2);
        int[] result4 = main.maxSlidingWindow(new int[]{1, -1}, 1);
        int[] result3 = main.maxSlidingWindow(nums3, k3);
        int[] result5 = main.maxSlidingWindow(new int[]{4, -2}, 2);
        System.out.println("end");
    }


}
