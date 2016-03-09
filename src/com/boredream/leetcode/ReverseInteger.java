package com.boredream.leetcode;

public class ReverseInteger {
	public static void main(String[] args) {
		// 没有注意到反转后超过int范围的情况
		int x = 1534236469;
		System.out.println(reverse(x));
	}

	public static int reverse(int x) {
		StringBuilder sb = new StringBuilder();
		if (x < 0) {
			sb.append(String.valueOf(x).substring(1));
		} else {
			sb.append(String.valueOf(x));
		}

		sb.reverse();
		
		int result;
		try {
			result = Integer.parseInt(sb.toString());
			if (x < 0) {
				result = -result;
			}
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}
}
