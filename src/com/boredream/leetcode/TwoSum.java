package com.boredream.leetcode;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 4 };
		int target = 6;
		
		int[] twoSum = twoSum(nums, target);
		for(int i : twoSum) {
			System.out.print(i + " ");
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] sum = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					sum[0] = i;
					sum[1] = j;
					return sum;
				}
			}
		}
		return null;
	}
}
