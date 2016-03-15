package com.boredream.leetcode;

public class AddDigits {

	public static void main(String[] args) {
		int num = 38;
		System.out.println(addDigits(num));
	}

	public static int addDigits(int num) {
		while(num >= 10) {
			int sum = 0;
			for (char c : String.valueOf(num).toCharArray()) {
				sum += Integer.parseInt(String.valueOf(c));
			}
			num = sum;
		}
		
		return num;
	}
}
