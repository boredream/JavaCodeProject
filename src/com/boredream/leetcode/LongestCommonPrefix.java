package com.boredream.leetcode;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = { "111", "111", "" };
		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		StringBuilder sb = new StringBuilder();
		Character commonPrefix = null;

		// 每次循环判断的字符位置
		out: for (int index = 0;; index++) {
			in: for (int i = 0; i < strs.length; i++) {
				String s = strs[i];
				if (s == null || s.length() == 0) {
					// 如果某个字符串是null, 则相同前缀为null,直接返回
					return "";
				}

				if(index > s.length() - 1) {
					// 某个字符串长度不够时,结束循环
					break out;
				}
				
				char prefixChar = s.charAt(index);
				if (i == 0) {
					// 第一个字符串时, 取前缀字符
					commonPrefix = prefixChar;
					continue in;
				}

				if (prefixChar != commonPrefix) {
					// 当前位置字符不相等时,结束循环
					break out;
				}

			}

			// 代码到这里都是该位置全部字符串的字符都相等
			// 则在通用字符串上添加当前字符, 同时位置+1判断下一轮字符
			sb.append(commonPrefix);
		}

		return sb.toString();
	}
}
