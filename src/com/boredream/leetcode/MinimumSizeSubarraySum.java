package com.boredream.leetcode;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int s = 88;
        System.out.println(minSubArrayLen(s, nums));
    }

    static int minSubArrayLen(int s, int[] nums) {
        int len = 0, sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= s && (len == 0 || j-i+1<len)) {
                    len = j-i+1;
                    break;
                }
            }
        }
        return len;
    }

}
