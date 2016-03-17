package com.boredream.leetcode;


public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

	public static void moveZeroes(int[] nums) {
		int zeroCount = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num == 0) {
				// 如果当前数字为0,则0数量+1
				zeroCount++;
			} else {
				// 如果当前数字非0,且已经有过0
				if (zeroCount > 0) {
					// 将当前数字左移0数量的位置
					nums[i - zeroCount] = num;
				}
			}
		}

		for (int i = 0; i < zeroCount; i++) {
			nums[nums.length - 1 - i] = 0;
		}
	}
}
