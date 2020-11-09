package com.kwq.algorithm.algorithmics.array;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/3
 * @DESC :
 */
//双指针法
public class Array_941 {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int left = 0, right = A.length - 1;
        while (left < right) {
            if (A[left] < A[left + 1]) left++;
            else break;
        }
        while (left < right) {
            if (A[right] < A[right - 1]) right--;
            else break;
        }
        return  left < A.length - 1 && left == right && right > 0;
    }

    public static void main(String[] args) {
        int [] array = {0,1,2,3,4,5,6,7,8,9};
        Array_941 main = new Array_941();
        boolean flag = main.validMountainArray(array);
        System.out.println(flag);
    }

}
