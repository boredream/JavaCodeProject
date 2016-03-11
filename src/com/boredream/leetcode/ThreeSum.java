package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		// Time Limit Exceeded
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length < 3) {
			return null;
		}

		Arrays.sort(nums);

		if (nums[0] > 0 || nums[nums.length - 1] < 0) {
			return null;
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<String> resultStr4dulpicate = new ArrayList<>();

		first: for (int i1 = 0; i1 < nums.length - 2 && nums[i1] <= 0; i1++) {
			second: for (int i2 = i1 + 1; i2 < nums.length - 1; i2++) {
				third: for (int i3 = i2 + 1; i3 < nums.length && nums[i3] >= 0; i3++) {
					int firstInt = nums[i1];
					int secondInt = nums[i2];
					int thirdInt = nums[i3];

					String resultStr;

					// 都<0时继续下一轮
					if (firstInt < 0 && secondInt < 0 && thirdInt < 0) {
						continue third;
					}

					// 都>0时,结束
					if (firstInt > 0 && secondInt > 0 && thirdInt > 0) {
						break first;
					}

					if (firstInt + secondInt + thirdInt == 0) {
						resultStr = "" + firstInt + secondInt + thirdInt;
						if (!resultStr4dulpicate.contains(resultStr)) {
							resultStr4dulpicate.add(resultStr);
							List<Integer> num3 = new ArrayList<Integer>();
							num3.add(firstInt);
							num3.add(secondInt);
							num3.add(thirdInt);
							result.add(num3);
							continue third;
						}
					}
				}
			}
		}

		return result.size() == 0 ? null : result;
	}
}
