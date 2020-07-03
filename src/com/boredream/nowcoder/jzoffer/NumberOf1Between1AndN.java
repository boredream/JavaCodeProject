package com.boredream.nowcoder.jzoffer;

/**
 * 找出数字里1出现的次数
 */
public class NumberOf1Between1AndN {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }

    static int NumberOf1Between1AndN_Solution(int n) {
        // 思路1：数字判断，每个数字判断每一位
        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            int number = i;
            int count = 0;
            while (number > 0) {
                if (number % 10 == 1) {
                    count++;
                }
                number /= 10;
            }
            totalCount += count;
        }
        return totalCount;
    }

}
