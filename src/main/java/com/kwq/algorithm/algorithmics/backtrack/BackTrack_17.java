package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/2
 * @DESC :
 */
public class BackTrack_17 {

    /** 17 .电话号码的字母组合
     * @num 17
     * @desdc 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        back(digits,0,new String(""),result,dict());
        return result;
    }

    /**
     *
     * @param digits 入参字符串
     * @param index 索引位置 代表从哪一个位置开始取值,比如index=1 且def  则取e
     * @param item 结果项
     * @param result 结果集
     * @param dict digits对应的映射字符串字典
     */
    private void back(String digits,int index,String item,List<String> result,List<String> dict){
        if(index == digits.length()){
            result.add(item);
            return;
        }
        //此处没必要两个for 代表第一个横向遍历(跨度) 确定了是从哪个字符串(通过index确定)开始选择组合字节
        String s = dict.get(Integer.parseInt(digits.charAt(index)+""));//a/b/c
        //此处代表纵向的for(深度)的单层逻辑
        for (int i = 0; i < s.length(); i++) {
            item += s.charAt(i);//chatAt(i)代表纵向被组合选择的字节
            back(digits,index+1,item,result,dict);//回溯index
            item = item.substring(0, item.length() - 1);//回溯item
        }
    }

    private static List<String> dict(){
        ArrayList<String> dict = new ArrayList<>();
        dict.add(0,"");
        dict.add(1,"");
        dict.add(2,"abc");
        dict.add(3,"def");
        dict.add(4,"ghi");
        dict.add(5,"jkl");
        dict.add(6,"mno");
        dict.add(7,"pqrs");
        dict.add(8,"tuv");
        dict.add(9,"wxyz");
        return dict;
    }

    public static void main(String[] args) {
        BackTrack_17 back = new BackTrack_17();
        List<String> strings = back.letterCombinations(new String("23"));
        System.out.println(strings);
    }
}
