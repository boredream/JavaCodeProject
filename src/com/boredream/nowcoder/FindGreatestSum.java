package com.boredream.nowcoder;

/**
 * 连续子数组的最大和，有正有负
 */
public class FindGreatestSum {

    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{-1,-2,1,2,3,-8,-2,4,10}));
    }

    static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int curSum = 0;
        int greatestSum = 0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                // 一旦累加到负数，就重置当前总数，把当前数字作为起始数
                curSum = array[i]; //记录当前最大值
            } else {
                curSum += array[i]; //当array[i]为正数时，加上之前的最大值并更新最大值。
            }

            // 每次都比较当前最大值，记录
            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }
}
