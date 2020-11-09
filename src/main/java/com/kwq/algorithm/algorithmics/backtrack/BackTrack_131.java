package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/6
 * @DESC :
 */
public class BackTrack_131 {


    public List<List<String>> partition(String s) {
        List<String> item = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        if(s == null) return null;
        if(s.length() == 0) return result;

        return null;
    }

    //双指针法
    //回文串
    public boolean sTs(String s){
        if(s == null) return false;
        if(s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BackTrack_131 back = new BackTrack_131();
        boolean flag = back.sTs("abcTcba");
        System.out.println(flag);
    }
}
