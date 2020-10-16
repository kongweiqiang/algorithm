package com.kwq.algorithm.algorithmics.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/14
 * @DESC :
 */
public class String_1002 {

    public static void main(String[] args) {
        String_1002 s = new String_1002();
        List<String> strings = s.commonChars("bella", "label", "roller");
    }

    /** 1002. 查找常用字符
     * @num 1002. 查找常用字符
     * @param A
     * @return
     */
    public List<String> commonChars(String ... A) {
        byte [][] dict = new byte[A.length][26];
        for(int i = 0;i < A.length; i++){
            for (int j = 0; j < A[i].length(); j++) {
                dict[i][A[i].charAt(j)-'a'] ++;
            }
        }
        System.out.println(dict);
        byte [] hash = dict[0];

        List<String> result = new ArrayList<String>();
        for(int i = 0;i<26;i++){
            for(int j = 0; j < dict.length;j++){
                hash[i] = dict[j][i]>hash[i]?hash[i]:dict[j][i];
                while(j == dict.length - 1 && hash[i] > 0){
                    result.add((char)(i+'a')+"");
                    hash[i]--;
                }
            }
        }
        return result;
    }
}
