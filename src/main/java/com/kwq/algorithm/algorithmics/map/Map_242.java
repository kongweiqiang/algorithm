package com.kwq.algorithm.algorithmics.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/27
 * @DESC :
 */
public class Map_242 {

    private Map<Character, Byte> map = new HashMap<>();
    public boolean isAnagram(String s, String t) {
        if(s!=null && s.equals(t)) return true;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),!map.containsKey(s.charAt(i)) ? (byte)1 : (byte)(map.get(s.charAt(i)).byteValue()+1));
        }
        for (int i = 0; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i))) return false;
            map.put(t.charAt(i),(byte)(map.get(t.charAt(i))-1));
        }
        return map.values().stream().allMatch(e -> e.byteValue() == (byte) 0);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        String t1 = "nagarme";
        Map_242 main = new Map_242();
        boolean anagram = main.isAnagram(s, t);
        boolean anagram1 = main.isAnagram(s,t1);
        System.out.println(anagram);
        System.out.println(anagram1);
    }

}
