package com.kwq.algorithm.algorithmics.greedy;

import java.util.Arrays;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/24
 * @DESC : 分发糖果
 */
public class Greedy_135 {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 2) return ratings == null? 0: ratings.length;
        int len = ratings.length;
        int[] result = new int[len];
        for(int i = 0;i < result.length;i++){
            result[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            if(ratings[i - 1] < ratings[i]){
                result[i] = result[i - 1] + 1;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if(ratings[i - 1] > ratings[i]){
                result[i - 1] = Math.max(result[i - 1],result[i] + 1);
            }
        }
        return Arrays.stream(result).sum();
    }

    public static void main(String[] args) {
        Greedy_135 main = new Greedy_135();
        System.out.println(main.candy(new int[]{1,0,2}));
        System.out.println(main.candy(new int[]{1,2,2}));
        System.out.println(main.candy(new int[]{1,3,4,5,2}));
    }
}
