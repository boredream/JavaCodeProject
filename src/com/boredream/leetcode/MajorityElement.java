package com.boredream.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中的绝大数数字，一定会有，且非空
 */
public class MajorityElement {

    public static void main(String[] args) {
        int nums[] = {1,2,3,3,3,3,4,3,3,5,5};
        System.out.println(majorityElement(nums));
    }

    /**
     * 思路：利用map计算数字出现的次数
     */
    static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.get(num);
            int count = value == null ? 1 : value+1;
            if(count > 1.0f*nums.length/2) return num;
            map.put(num, count);
        }
        return 0;
    }

}
