package com.kwq.algorithm.algorithmics.sort;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/4
 * @DESC : 堆排
 * @idea :
 * 大顶堆根节点最大与最后一个节点交换(最大元素沉底)实现升序
 * 小顶堆根节点最小与最后一个节点交换(最小元素沉底)实现降序
 * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆函数，二是反复调用建堆函数以选择出剩余未排元素中最大的数来实现排序的函数。
 *
 * 总结起来就是定义了以下几种操作：
 *
 * 最大堆调整(Max_Heapify)：将堆的末端子节点作调整，使得子节点永远小于父节点
 * 创建最大堆(Build_Max_Heap)：将堆所有数据重新排序
 * 堆排序(HeapSort)：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 * 对于堆节点的访问：
 *
 * 父节点i的左子节点在位置：(2*i+1);
 * 父节点i的右子节点在位置：(2*i+2);
 * 子节点i的父节点在位置：floor((i-1)/2);
 *
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 *
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 *
 * @step :
 * 大顶堆排升序
 * 第一步：先n个元素的无序序列，构建成大顶堆
 * 第二步：将根节点与最后一个元素(长度/2 - 1)交换位置，(将最大元素"沉"到数组末端)
 * 第三步：交换过后可能不再满足大顶堆的条件，所以需要将剩下的n-1个元素重新构建成大顶堆
 * 第四步：重复第二步、第三步直到整个数组排序完成
 */
public class HeapSort {

    /* Function: 构建大顶堆*/
    private void buildMaxHeap(int [] arr,int len) {
        if (arr.length <= 0 || arr.length < len) return;
        //找父位置
        int parentIdx = len / 2;
        //循环递减
        for (; parentIdx >= 0; parentIdx--) {
            if (parentIdx * 2 >= len) {
                continue;
            }
            //找左子位置
            int left = parentIdx * 2;       //左子节点位置
            //找右子位置
            int right = (left + 1) >= len ? left : (left + 1);    //右子节点位置，如果没有右节点，默认为左节点位置
            //左右比较找出最大值位置
            int maxChildId = arr[left] >= arr[right] ? left : right;
            //最大值沉底
            if (arr[maxChildId] > arr[parentIdx]) {   //交换父节点与左右子节点中的最大值
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[maxChildId];
                arr[maxChildId] = temp;
            }
            QuickSort.print(arr);
        }
    }

    /* Function: 交换根节点和数组末尾元素的值*/
    private void swap(int[] arr,int len){
        int temp = arr[0];
        arr[0] = arr[len - 1];
        arr[len - 1] = temp;
    }

    public void heapSort(int[] arr){
        for(int i = arr.length; i > 0; i--){
            buildMaxHeap(arr, i);
            swap(arr,i);
        }
    }

    public static void main(String[] args) {
        int [] arr = { 1, 3, 4, 5, 2, 6, 9, 7, 8, 0 };
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        QuickSort.print(arr);
    }
    
}
