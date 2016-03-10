package com.boredream.leetcode;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aaa", "aa"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}

	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		if (!p.contains("*") && s.length() != p.length()) {
			return false;
		}

		if (!p.contains("*") && !p.contains(".")) {
			return s.equals(p);
		}

		boolean isMatch = true;
		for (int sIndex = 0, pIndex = 0; sIndex < s.length()
				&& pIndex < p.length();) {
			// 如果有下一个字符,且为*
			int pIndexNext = pIndex + 1;
			boolean nextStar = false;
			if (pIndexNext < s.length()) {
				nextStar = p.charAt(pIndexNext) == '*';
			}
			
			
			
			char sChar = s.charAt(sIndex);
			char pChar = p.charAt(pIndex);
			if (sChar == pChar) {
				continue;
			}

			break;
		}

		return isMatch;
	}
}
