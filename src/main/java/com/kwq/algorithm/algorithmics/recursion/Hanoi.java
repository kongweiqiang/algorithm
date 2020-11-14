package com.kwq.algorithm.algorithmics.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/13
 * @DESC : 汉诺塔问题
 */
public class Hanoi {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();

        List<String> result = new ArrayList<>();
        hanoi.hanoi(3,"A","C","B",null,result);
        System.out.println(result);
    }

    public void hanoi(int n, String from, String to, String middle, String item,List<String> result){
        if(n == 1){
            item = n + ":" + from + "-->" + to;
            result.add(item);
            return;
        }
        hanoi(n-1,from,middle,to,item,result);
        item = n + ":" + from + "-->" + to;
        result.add(item);
        hanoi(n-1,middle,to,from,item,result);
    }

}
