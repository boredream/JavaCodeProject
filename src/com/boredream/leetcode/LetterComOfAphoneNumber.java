package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterComOfAphoneNumber {

	public static void main(String[] args) {
		String digits = "23";
		System.out.println(letterCombinations(digits));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

		String[] charmap = { "0", "1", "abc", "def", "ghi", "jkl", "mno",
				"pqrs", "tuv", "wxyz" };

		int changeIndex = 0;
		for (int i = 0; i<charmap[changeIndex].length(); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < digits.length(); j++) {
				int digit = Integer.parseInt(digits.charAt(j)+"");
				sb.append(charmap[digit]);
			}
		}

		return result;
	}
}
