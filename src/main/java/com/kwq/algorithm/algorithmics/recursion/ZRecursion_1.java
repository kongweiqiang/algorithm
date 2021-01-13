package com.kwq.algorithm.algorithmics.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/29
 * @DESC : 输出字符串的所有子序列
 * @idea: 选择决策:要么要/要么不要
 */
public class ZRecursion_1 {

    public static void process1(char [] c, int index, String item, List<String> result){
        result.add(new String(item));
        if(index >= c.length){
            return;
        }
        for (int i = index; i < c.length; i++) {
            item += c[i++];
            process1(c,i,item,result);
            item.substring(0,item.length() - 1);
            i--;
        }
    }

    public static void main(String[] args) {
        String s = "123456";
        ArrayList<String> result = new ArrayList<>();
        process1(s.toCharArray(),0,"",result);
        System.out.println(result);
    }

}
