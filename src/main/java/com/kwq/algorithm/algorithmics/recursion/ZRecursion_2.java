package com.kwq.algorithm.algorithmics.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/12/29
 * @DESC : 全排列
 */
public class ZRecursion_2 {

    public static List<String> premutation1(String s){
        List<String> ans = new ArrayList<>();
        if(s == null || s.length() == 0) return  ans;
        char[] str = s.toCharArray();
        List<Character> rest = new ArrayList<>();
        for (char c : str) {
            rest.add(c);
        }
        String path = "";
        f(rest,path,ans);
        return ans;
    }

    public static void f(List<Character> rest,String path,List<String> ans){
        if(rest.isEmpty()) {
            ans.add(path);
            return;
        }
        int len = rest.size();
        for (int i = 0; i < len; i++) {
            char c = rest.get(i);
            rest.remove(i);//去掉当前c字符
            f(rest,path + c,ans);
            rest.add(i,c);//回溯
        }
    }

    public static void main(String[] args) {
        List<String> ans = premutation1("abc");
        System.out.println(ans);
    }
}
