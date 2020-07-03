package com.boredream.nowcoder.jzoffer;

/**
 * 斐波那契数列。1 1 2 3 5 8 13 21
 */
public class Fibonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " = " + Fibonacci2(i));
        }
    }

    private static int Fibonacci1(int n) {
        // 思路1：典型动态规划问题。后一个结果依赖于前面已算出的结果。使用递归
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    private static int Fibonacci2(int n) {
        // 思路2：同样思路，只是方法用循环替代递归，效率高；
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int n1 = 1; // fn-1
        int n2 = 1; // fn-2
        int total = 0;
        for (int i = 3; i <= n; i++) {
            total = n1 + n2;
            n2 = n1;
            n1 = total;
        }
        return total;
    }
}
