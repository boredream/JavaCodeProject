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
				// �����ǰ����Ϊ0,��0����+1
				zeroCount++;
			} else {
				// �����ǰ���ַ�0,���Ѿ��й�0
				if (zeroCount > 0) {
					// ����ǰ��������0������λ��
					nums[i - zeroCount] = num;
				}
			}
		}

		for (int i = 0; i < zeroCount; i++) {
			nums[nums.length - 1 - i] = 0;
		}
	}
}
