package com.kwq.algorithm.algorithmics.array;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/16
 * @DESC :
 */
public class Array_998 {

    public static void main(String[] args) {
        Array_998 array = new Array_998();
        int [] A = {-7,-3,2,3,11};
        array.sortedSquares(A);
        array.merge(new int[]{2,0},1,new int[]{1},1);
        array.merge(new int[]{4,5,6,0,0,0},3,new int[]{1,2,3},3);
        array.merge(new int[]{0},0,new int[]{1,2,5},3);
    }

    /** 977. 有序数组的平方
     * @num 977. 有序数组的平方
     * @desc 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序
     * @param A
     * @eg  输入：[-7,-3,2,3,11]
     *      输出：[4,9,9,49,121]
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int [] result = new int[A.length];
        int k = A.length - 1;
        for(int pre = 0, post = A.length - 1;pre <= post;)
            if (Math.abs(A[pre]) <= Math.abs(A[post])) {
                result[k--] =A[post]*A[post];
                post--;
            }else{
                result[k--] =A[pre]*A[pre];
                pre++;
            }
        return result;
    }

    /** 88.合并两个数组
     * @num 88
     * @desc 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组
     * @param nums1 有序nums1数组空间足够:nums1.length == m + n
     * @param m nums1中数组初始化的个数
     * @param nums2 有序
     * @param n nums2中数组初始化的个数:nums2.length == n
     * @eg 输入：nums1 = [1,2,3,0,0,0] m = 3 nums2 = [2,5,6] n = 3
     *     输出：[1,2,2,3,5,6]
     *     [4,5,6,0,0,0] 3 [1,2,3] 3 ----> [1,2,3,4,5,6]
     *     [0] 0 [1,2,3] 3 ----> [1,2,3]
     *     [2,0] 1 [1] 1 ----> [1,2]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //填充总长度
        int length = m + n - 1;
        for(int i = length;i>0 && n>0 && m>0;i--){
            //nums1元素中比nums2中元素大
            if(nums1[m-1] > nums2[n-1]){
                /**
                 * nums1[i] = nums1[m-1];
                 * m--;
                 */
                nums1[i] = nums1[--m];
            }else{
                nums1[i] = nums2[--n];
            }
        }
        //将nums2中的与nums1比较后未填充的数组元素进行数据填充到nums1
        System.arraycopy(nums2, 0, nums1, 0, n);
    }
}
