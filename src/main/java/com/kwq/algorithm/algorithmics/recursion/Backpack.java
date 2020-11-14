package com.kwq.algorithm.algorithmics.recursion;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/14
 * @DESC : 背包问题
 */
public class Backpack {

    /**
     * 背包问题
     * @param weight 重量
     * @param value 价值
     * @param index 备选方案位置
     * @param capacity 背包剩余容量大小
     * @return
     */
    public int backpack(int[] weight, int[] value, int index, int capacity){
        if(index < weight.length && weight[index] < capacity) {
            int unChoice = backpack(weight, value, index + 1, capacity);
            int choice = backpack(weight, value, index + 1, capacity - weight[index]) + value[index];
            return Math.max(unChoice, choice);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1,2,1,2};
        int[] value = new int[]{2,1,5,10};
        int capacity = 5;
        Backpack main = new Backpack();
        int maxValue = main.backpack(weight, value, 0, capacity);
        System.out.println(maxValue);
    }

}
