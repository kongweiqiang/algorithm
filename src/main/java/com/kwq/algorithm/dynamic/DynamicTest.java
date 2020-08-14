package com.kwq.algorithm.dynamic;

/**
 * @auther : kongweiqiang
 * @DATE : 2019\11\28
 * @DESC :
 */
public class DynamicTest {

    public static void main(String[] args) {
        /*String s1= "abced";
        String s2= "cdedcacd";
        Subsequence subsequence = new Subsequence();
        int i = subsequence.longestCommonSubsequence(s1, s2);
        System.out.println(i);*/
        String s1= "^-^abdc^";
        System.out.println(s1.replaceAll("^-^", "uuu"));
        System.out.println(s1.replaceAll("\\^-^", "uuu"));
        System.out.println(s1.replaceAll("\\^\\-\\^", "uuu"));
        System.out.println(s1.replaceAll("\\^-\\^", "uuu"));
    }
}
