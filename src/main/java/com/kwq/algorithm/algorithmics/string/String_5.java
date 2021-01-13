package com.kwq.algorithm.algorithmics.string;

/**
 * @number : 5. 最长回文子串
 * @auther : kongweiqiang
 * @DATE : 2020/12/26
 * @DESC : 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 */
public class String_5 {

    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        char c = '#';
        StringBuilder sb = new StringBuilder(c + "");
        //index记录当前位置 start记录符合条件的起始位置 offset记录start的发散偏移量
        int index = 0,len = s.length(),start = 0,offset = 0;
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i)).append(c);
        }
        int length = sb.length();
        for (int i = 1; i < length; i++) {
            while(i - index >= 0 && i + index < length && index < i && sb.charAt(i - index) == (sb.charAt(i + index))){
                if(index > offset) {
                    start = i;
                    offset = index;
                }
                index ++;
            }
            index = 0;
        }
        String ss = sb.substring(start - offset, start + offset + 1);
        if(ss.length() < 2) return ss;
        // 反序列化
        StringBuilder builder = new StringBuilder("");
        int i = ss.charAt(0) == c ? 1 : 0;
        while(i < ss.length()){
            builder.append(ss.charAt(i));
            i += 2;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String_5 main = new String_5();
        System.out.println(main.longestPalindrome("ababbdcdeefscd"));
        System.out.println(main.longestPalindrome("dddsffsssssffedead"));
        System.out.println(main.longestPalindrome("dddsffssssffedead"));
        System.out.println(main.longestPalindrome("adb"));
        System.out.println(main.longestPalindrome("babad"));
        System.out.println(main.longestPalindrome("bb"));
        System.out.println(main.longestPalindrome("b"));
        System.out.println(main.longestPalindrome("ac"));
        System.out.println(main.longestPalindrome("abb"));
    }
}
