package com.kwq.algorithm.algorithmics.array;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/1
 * @DESC :
 */
public class Sort {



    /**
     * 快排 : 两边同时收缩,交互
     * @eg {1,4,6,9,10,2,3,5,8,7}
     * @param array
     * @param left
     * @param right
     */
    public void quickSort(int [] array,int left,int right){
        if(left >= right || right - left == 1) return;
        int partion = partion(array,left,right);
        quickSort(array,left,partion-1);
        quickSort(array,partion,right);
    }

    public int partion(int [] array,int left,int right){
        int sentinel = array[right];//标杆
        int bound = right--;//right-- 排除标杆 保证右指针查找从标杆前一位开始
        while (left < right) {
            while(left <= right && array[left] <= sentinel) left++;
            while(left < right && array[right] >= sentinel) right--;
            if(left >= right) {
                swap(array,left,bound,bound,sentinel);
                return left;
            }
            System.out.println("index : left -> " + left + "; right -> " + right);
            swap(array,left,right,bound,sentinel);
        }
        swap(array,left,bound,bound,sentinel);
        return left;
    }

    private void swap(int [] array,int start,int end,int senIndex,int sen){
        print(array);
        System.out.println("senIndex->"+senIndex + " ;senValue ->"+sen);
        System.out.println("index : left -> " + start + "; right -> " + end +";swap : " + array[start] + " <----> " + array[end]);
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    private void print(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(i == array.length-1 ? array[i]: (array[i] + " -> "));
        }
        System.out.println();
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        int [] array = {1,4,6,9,10,2,3,5,8,7};
        Sort sort = new Sort();
        sort.quickSort(array,0,array.length-1);
        sort.print(array);
    }
}
