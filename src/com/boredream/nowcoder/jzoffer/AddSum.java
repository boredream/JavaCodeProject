package com.boredream.nowcoder.jzoffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class AddSum {

    public static void main(String[] args) {
        System.out.println(Sum_Solution(5));
    }

    static int Sum_Solution(int n) {
        // 思路1：按说应该直接n(n+1)/2，但是不能乘除法。就只能累加~ 又不能for循环啥的，用递归？但是递归要if吧
        // 看了网上，使用 && 进行中断
        int sum = n;
        boolean flag = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
