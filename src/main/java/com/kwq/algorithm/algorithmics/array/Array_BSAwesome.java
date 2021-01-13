package com.kwq.algorithm.algorithmics.array;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/23
 * @DESC :
 */
public class Array_BSAwesome {

    /**
     * 返回局部最小数据的下标位置
     * @param arr
     * @return
     */
    public static int oneMinIndex(int [] arr){
        if(arr == null || arr.length == 0) return -1;
        int len = arr.length;
        if(len == 1) return arr[0];
        if(len == 2) return arr[0] < arr[1] ? 0 : 1;
        if(arr[len-1] < arr[len-2]) return len - 1;
        int l = 0,r = len - 1,result = -1;
        while(l <= r){
            int mid = l + (r - l) >>> 1;
            if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]){
                result = mid;
                break;
            }else{
                if(arr[mid] > arr[mid - 1]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return arr[l] < arr[r] ? l : r;
    }

}
