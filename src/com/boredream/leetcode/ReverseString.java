package com.boredream.leetcode;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }

    static String reverseString(String s) {
        if(s == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = s.toCharArray().length - 1; i >= 0; i--) sb.append(s.charAt(i));
        return sb.toString();
    }

}
