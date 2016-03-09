package com.boredream.leetcode;

public class PalindromeNumber {
	public static void main(String[] args) {
		int i = 121;
		System.out.println(isPalindrome(i));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		String s = String.valueOf(x);
		if (s.length() == 1) {
			return true;
		}

		boolean isEven = s.length() % 2 == 0;
		boolean isPalindrome = true;
		int left;
		int right;
		if (isEven) {
			left = s.length() / 2 - 1;
			right = s.length() / 2;
		} else {
			left = s.length() / 2 -1;
			right = s.length() / 2 + 1;
		}

		for (; left >= 0 && right <= s.length() - 1; left--, right++) {
			if (s.charAt(left) != s.charAt(right)) {
				isPalindrome = false;
				break;
			}
		}

		return isPalindrome;
	}
}
