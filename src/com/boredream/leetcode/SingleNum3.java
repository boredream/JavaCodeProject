package com.boredream.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNum3 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		int[] singleNumber = singleNumber(nums);
		for (int num : singleNumber) {
			System.out.print(num);
		}
	}

	public static int[] singleNumber(int[] nums) {
		Set<Integer> singleNumSet = new HashSet<>();
		for (int num : nums) {
			if (!singleNumSet.remove(num)) {
				singleNumSet.add(num);
			}
		}
		int[] result = new int[singleNumSet.size()];
		int index = 0;
		for (Integer num : singleNumSet) {
			result[index++] = num;
		}
		return result;
	}
}
