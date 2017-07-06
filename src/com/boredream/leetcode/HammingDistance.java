package com.boredream.leetcode;

public class HammingDistance {

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        String s = Integer.toBinaryString(x^y);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

}
