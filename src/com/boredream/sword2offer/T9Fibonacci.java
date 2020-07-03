package com.boredream.sword2offer;

public class T9Fibonacci {

    /**
     * 写一个函数，输入n，求斐波那契（Fibonacci) 数列的第n项（1 1 2 3 5 8 13 。。。）
     * @param n Fibonacci数的项数
     * @return 第n项的结果
     */
    public static long fibonacci(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return 1;

        int pre1 = 1;
        int pre2 = 1;
        int total = 0;
        for (int i = 3; i <= n; i++) {
            total = pre1 + pre2;
            pre1 = pre2;
            pre2 = total;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
    }

}
