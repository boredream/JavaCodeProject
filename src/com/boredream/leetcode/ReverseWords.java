package com.boredream.leetcode;


public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.toCharArray().length - 1, insert = 0; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                sb.insert(0, ' ');
                insert = 0;
                continue;
            }
            sb.insert(insert, s.charAt(i));
            insert ++;
        }
        return sb.toString();
    }
}
