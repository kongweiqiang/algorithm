package com.kwq.algorithm.algorithmics.array;

import com.kwq.algorithm.algorithmics.sort.QuickSort;

import java.util.*;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/27
 * @DESC :
 */
public class Array_349 {

    /**
     * 349. 两个数组的交集
     * @num 349
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int item :  nums1) {
            set.add(item);
        }
        List<Integer> list = new ArrayList<>();
        for (int item : nums2) {
            if(set.contains(item)){
                set.remove(item);
                list.add(item);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int [] a = {1,2,2,1};
        int [] b = {2,2};
        Array_349 main = new Array_349();
        int[] result = main.intersection(a, b);
        QuickSort.print(result);
    }
}
