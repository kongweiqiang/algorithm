package com.kwq.algorithm.algorithmics.sort;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/8
 * @DESC : 归并 ----> 优化版 多路归并算法:TimSort java对象比较使用
 *          java 对象比较采用归并排序
 *          适合范围有序的数组进行排序(分段子数组有序)
 *          稳定
 *          时间:NlogN 空间:N
 */
public class MergeSort {

    public void mergeSort(int[] arr,int left,int right){
        //base case
        if(left >= right) return;
        int h = left + (right - left)/2;
        mergeSort(arr,left,h);
        mergeSort(arr,h+1,right);
        //此处是"h+1" 表示从h+1 作为右侧开始点 即:[left,h] [h+1,right]
        merge(arr,left,h+1,right);
    }

    /**
     * 数组 归并
     * @param arr 数组
     * @param left 左指针位置(左指针边界值)
     * @param right 右指针位置
     * @param rightBound 右指针边界值
     */
    public void merge(int[] arr,int left,int right,int rightBound){
        int[] temp = new int[rightBound - left + 1];
        int i = left;
        int j = right;
        int k = 0;
        while(i < right && j <= rightBound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while(i < right) temp[k++] = arr[i++];
        while(j <= rightBound) temp[k++] = arr[j++];
        //辅助数组回写原数组
        for(int x = 0;x < temp.length;x++){
            arr[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,7,8,3,6,9};
        MergeSort mergeSort = new MergeSort();
        //mergeSort.merge(arr,1,4,6);
        mergeSort.mergeSort(arr,0,arr.length - 1);
        QuickSort.print(arr);
    }

}
