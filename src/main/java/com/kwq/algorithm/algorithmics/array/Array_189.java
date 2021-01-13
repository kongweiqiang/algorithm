package com.kwq.algorithm.algorithmics.array;

/**
 * @auther : kongweiqiang
 * @DATE : 2021/1/8
 * @DESC : 189. 旋转数组: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * @eg :
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class Array_189 {

    /**
     * 旋转数组: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
     *
     * @param nums 数组
     * @param k    向右移动的偏移量
     * @number 189
     */
    public void rotate(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) return;
        //if (k > nums.length) k = k % nums.length;
        f(nums, 0, nums.length - k - 1);
        f(nums, nums.length - k, nums.length - 1);
        f(nums, 0, nums.length - 1);
    }

    private void f(int[] nums, int left, int right) {
        if (left >= right || nums == null || nums.length == 0) return;
        while (left < right) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Array_189 main = new Array_189();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1, -100, 3, 99};
        int k1 = 3;
        int k2 = 2;
        main.rotate(nums1, k1);
        main.rotate(nums2, k2);
        System.out.println("end");
    }
}
