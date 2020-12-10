package com.kwq.algorithm.algorithmics.sort;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/30
 * @DESC :
 */
public class QuickSort2 {
    public static void quickSortHelp(int[] arr) {
        quickSort(arr,0, arr.length-1);
    }
    public static void quickSort(int[] arr,int low, int high) {
        if(low<high) {
            int partition = partition(arr,low,high);
            quickSort(arr,low, partition-1);
            quickSort(arr,partition+1, high);
        }

    }
    public static int partition(int[] arr,int low,int high) {
        while(low<high) {
            while(arr[high]>=arr[low]&&low<high){
                high--;
            }
            Swap(arr,low,high);
            while(arr[low]<=arr[high]&&low<high) {
                low++;
            }
            //Swap(arr,high,low);
        }
        return low;
    }
    public static void Swap(int[] arr,int high,int low) {
        int temp = arr[low];
        arr[low] =arr[high];
        arr[high] = temp;
    }
    public static void main(String[] args) {
        int[] array = { 2, 8, 5, 6, 10, 5, 4, 6, 11, 15, 3 };
        //int[] array = {1,4,6,9,10,2,3,5,8,7};
        quickSortHelp(array);
        for (int s : array) {
            System.out.print(s + " ");
        }
    }
}
