package com.boredream.leetcode;

public class NimGame {
	public static void main(String[] args) {
		// 这他妈不是大航海里面酒馆招那谁的题目吗
		System.out.println(canWinNim(0));
	}

	public static boolean canWinNim(int n) {
		return n % 4 != 0;
	}
}
