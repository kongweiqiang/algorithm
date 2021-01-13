package com.kwq.algorithm.algorithmics.sort;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/16
 * @DESC : 插排
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] arr = {7,1,3,6,8,2,7,0};
        print(arr);
        insertSort(arr);
        print(arr);
    }

    public static void insertSort(int [] arr){
        for(int i = 1 ;i < arr.length ; i++){
            for(int j = i - 1; j >= 0; j --){
                if(arr[i] < arr[j]) {
                    swap(arr,i,j);
                    // 回退指针 保证相邻两两交互 i每前进一步,都要交换k次(k = j -- 的次数)
                    // 优化: 用count记录回退的步数,然后直接交换i 和 i - count(j) 的位置 , i每前进一步,只做一次交换
                    i--;
                }
            }
        }
    }

    private static void swap(int [] arr,int i, int j) {
        System.out.println("交换前:i : "+ i + "-->arr[i]:"+arr[i]+",j : "+ j+ "-->arr[j]:"+arr[j]);
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        System.out.println("交换后:i : "+ i + "-->arr[i]:"+arr[i]+",j : "+ j+ "-->arr[j]:"+arr[j]);
        print(arr);
    }

    private static void print(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ( i == arr.length - 1 ? "" : " -> " ));
        }
        System.out.println("");
        System.out.println("---------------");
    }
}
