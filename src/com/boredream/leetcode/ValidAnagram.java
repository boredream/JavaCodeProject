package com.boredream.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 求俩字符串所有字母出现次数相等
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "a", t = "b";
        System.out.println(isAnagram(s, t));
    }

    /**
     * 思路，map保存重复字母的次数，分别存俩map，然后挨个对比
     */
    static boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            smap.put(s.charAt(i), smap.get(s.charAt(i)) == null ? 1 : smap.get(s.charAt(i))+1);
            tmap.put(t.charAt(i), tmap.get(t.charAt(i)) == null ? 1 : tmap.get(t.charAt(i))+1);
        }
        if(smap.keySet().size() != tmap.keySet().size()) return false;
        for (Character c : smap.keySet()) {
            if(tmap.get(c) == null || !smap.get(c).equals(tmap.get(c))) return false;
        }
        return true;
    }
}
