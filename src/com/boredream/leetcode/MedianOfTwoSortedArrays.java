package com.boredream.leetcode;

import java.util.ArrayList;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = { 3, 5 };
		int[] nums2 = { 1, 2, 6 };
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = -1;
		int m = nums1.length;
		int n = nums2.length;
		ArrayList<Integer> totalArray = new ArrayList<>();
		for (int i = 0, j = 0; ;) {
			if (i > m - 1) {
				totalArray.add(nums2[j]);
				j++;
			} else if (j > n - 1) {
				totalArray.add(nums1[i]);
				i++;
			} else {
				if (nums1[i] < nums2[j]) {
					totalArray.add(nums1[i]);
					i++;
				} else if (nums1[i] > nums2[j]) {
					totalArray.add(nums2[j]);
					j++;
				} else {
					totalArray.add(nums1[i]);
					totalArray.add(nums2[j]);
					i++;
					j++;
				}
			}
			
			if(i == m && j == n) {
				break;
			}
		}

		if ((m + n) % 2 == 0) {
			median = ((double) totalArray.get((m + n) / 2 - 1) + totalArray
					.get((m + n) / 2)) / 2;
		} else {
			median = totalArray.get((m + n + 1) / 2 - 1);
		}
		return median;
	}
}
