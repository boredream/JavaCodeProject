package com.boredream.leetcode;

public class Q264nthUglyNumber {

    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
        }
        System.out.println(nthUglyNumber(10));
    }

    static int nthUglyNumber(int n) {
        // FIXME: 2019/11/15
        int result = 1;
        int last2 = 1;
        int last3 = 1;
        int last5 = 1;
        for (int i = 0; i < n - 1; i++) {
            int n2 = last2 * 2;
            int n3 = last3 * 3;
            int n5 = last5 * 5;
            result = Math.min(Math.min(n2, n3), n5);
            if (n2 == result) {
                last2 = result;
            }
            if (n3 == result) {
                last3 = result;
            }
            if (n5 == result) {
                last5 = result;
            }
        }
        return result;
    }

}
