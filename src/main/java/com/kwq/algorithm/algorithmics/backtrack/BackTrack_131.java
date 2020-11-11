package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/6
 * @DESC : 分割回文串
 */
public class BackTrack_131 {

    public List<List<String>> partition(String s) {
        List<String> item = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        if(s == null) return null;
        if(s.length() == 0) return result;
        back(s,0,item,result);
        return result;
    }

    private void back(String s,int index,List<String> item,List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(item));
            return;
        }
        for(int i = index;i<s.length();i++){
            if(sTs(s.substring(index,i + 1))){
                item.add(s.substring(index,i + 1));
            }else{
                continue;
            }
            back(s,i + 1,item,result);
            item.remove(item.size() - 1);
        }
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
        //boolean flag = back.sTs("abcTcba");
        List<List<String>> result = back.partition("aab");
        System.out.println(result);
    }
}
