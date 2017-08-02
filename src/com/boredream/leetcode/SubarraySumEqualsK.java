package com.boredream.leetcode;

/**
 * Created by lichunyang on 2017/7/31.
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{0,0,0}, 0));
    }

    static int subarraySum(int[] nums, int k) {
        int count = 0;
        int startIndex = 0;
        int index = 0;
        int sum = 0;
        while(true) {
            if(index > startIndex && sum == k) count ++;

            if(index == nums.length) {
                index = ++startIndex;
                sum = 0;
                if(startIndex == nums.length) break;
                else continue;
            }

            // 累加
            sum += nums[index++];
        }
        return count;
    }

//    static int subarraySum(int[] nums, int k) {
//        for(int sum=0,startIndex=0,index=0; ; ) {
//            if(sum == k) return index - startIndex; // 如果数字达到了，就结束
//            if(index == nums.length) break;
//            if(sum > k) {
//                index = ++startIndex; // 如果超过了，重新从下一个起始点开始遍历
//                sum = 0;
//            } else {
//                sum += nums[index++];
//            }
//        }
//        return 0;
//    }

    /**
     * 题目理解错误，以为是任意一个连续数字到k就返回这组数字的count。。。
     * 其实应该是一共有多少连续数字可以等于k~
     *
     * 理解正确后，发现又有细节没考虑清楚，开始觉得只要超过k，就start++，其实后面可能是负数再减回来
     * 还有就是，==k后，就start++，不对，后面可能还有+1-1又是一个答案
     */

}
