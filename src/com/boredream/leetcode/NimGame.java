package com.boredream.leetcode;

public class NimGame {
	public static void main(String[] args) {
		// �����費�Ǵ󺽺�����ƹ�����˭����Ŀ��
		System.out.println(canWinNim(0));
	}

	public static boolean canWinNim(int n) {
		return n % 4 != 0;
	}
}
