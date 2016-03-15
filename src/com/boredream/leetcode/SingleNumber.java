package com.boredream.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 3};
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> numCountMap = new HashMap<>();
		for(int num : nums) {
			Integer savedNum = numCountMap.get(num);
			if(savedNum == null) {
				numCountMap.put(num, 1);
			} else {
				numCountMap.remove(num);
			}
		}
		
		return numCountMap.keySet().iterator().next();
	}
}
