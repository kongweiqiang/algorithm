package com.kwq.algorithm.algorithmics.string;

import java.util.HashMap;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/16
 * @DESC :
 */
public class String_3 {
    /**  **滑动窗口模板
     * 3.无重复字符的最长子串
     * @num 3
     * @eg
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int sum = 0;
        int left = 0;
        if(s == null || s.length() == 0) return sum;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            sum = Math.max(sum,i - left +1);
        }
        return sum;
    }

    public static void main(String[] args) {
        String_3 string3 = new String_3();
        String s0 = "abcabcbb";
        String s1 = "pwwkew";
        String s2 = "bbbbb";
        int sum0 = string3.lengthOfLongestSubstring(s0);
        int sum1 = string3.lengthOfLongestSubstring(s1);
        int sum2 = string3.lengthOfLongestSubstring(s2);
        System.out.println(sum0);
        System.out.println(sum1);
        System.out.println(sum2);
    }
}
