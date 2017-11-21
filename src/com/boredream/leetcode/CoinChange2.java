package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给定几个不同面额的硬币，求有多少种组合达到某个数字，硬币可以重复使用组合
 */
public class CoinChange2 {

    public static void main(String[] args) {

    }

    /**
     * 思路：从大到小排列，前面单个数字超过的都跳过
     * 后面弄个开始索引，然后不停的累加当前或后面数字，到最后一个数字停止
     */
//    static int change(int amount, int[] coins) {
//        if(coins == null || coins.length == 0) return 0;
//        Arrays.sort(coins);
//        int result = 0;
//        int sum = 0;
//        int index = coins.length;
//        while (true) {
//            while (true) {
//                sum += coins[index];
//            }
//
//        }
//        return result;
//    }

}
