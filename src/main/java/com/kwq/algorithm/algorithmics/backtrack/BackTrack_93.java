package com.kwq.algorithm.algorithmics.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/11/13
 * @DESC :
 */
public class BackTrack_93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null) return null;
        if(s.length() == 0) return result;
        back(s,0,"",result);
        return result;
    }

    private void back(String s, int index,String temp, List<String> result) {
        String[] split = temp.split("\\.");
        if(split.length>0 && split[split.length-1].length()>1 && split[split.length-1].charAt(0)=='0'){
            return;
        }
        if(split.length > 4) return;
        int num = 0;
        for (int i = 0; i < split[split.length - 1].length(); i++) {
            if (split[split.length - 1].charAt(i) > '9' || split[split.length - 1].charAt(i) < '0') {
                return ;
            }
            num = num * 10 + (split[split.length - 1].charAt(i) - '0');
            if (num > 255) {
                return;
            }
        }
        if(s.length() == index && split.length == 4){
            result.add(temp);
            return;
        }
        for(int i = index;i < s.length();i++){
            back(s,i+1,temp + (temp.equals("")?temp:".") + s.substring(index,i+1),result);//递归回溯
        }
    }

    public static void main(String[] args) {
        BackTrack_93 main = new BackTrack_93();
        List<String> result = main.restoreIpAddresses("25525511135");
        System.out.println(result);
        List<String> result1 = main.restoreIpAddresses("0000");
        System.out.println(result1);
        List<String> result2 = main.restoreIpAddresses("1111111111111111");
        System.out.println(result2);
        List<String> result3 = main.restoreIpAddresses("010010");
        System.out.println(result3);
        List<String> result4 = main.restoreIpAddresses("101023");
        System.out.println(result4);
    }
}
