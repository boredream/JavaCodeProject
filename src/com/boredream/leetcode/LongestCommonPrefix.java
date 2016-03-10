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

		// ÿ��ѭ���жϵ��ַ�λ��
		out: for (int index = 0;; index++) {
			in: for (int i = 0; i < strs.length; i++) {
				String s = strs[i];
				if (s == null || s.length() == 0) {
					// ���ĳ���ַ�����null, ����ͬǰ׺Ϊnull,ֱ�ӷ���
					return "";
				}

				if(index > s.length() - 1) {
					// ĳ���ַ������Ȳ���ʱ,����ѭ��
					break out;
				}
				
				char prefixChar = s.charAt(index);
				if (i == 0) {
					// ��һ���ַ���ʱ, ȡǰ׺�ַ�
					commonPrefix = prefixChar;
					continue in;
				}

				if (prefixChar != commonPrefix) {
					// ��ǰλ���ַ������ʱ,����ѭ��
					break out;
				}

			}

			// ���뵽���ﶼ�Ǹ�λ��ȫ���ַ������ַ������
			// ����ͨ���ַ�������ӵ�ǰ�ַ�, ͬʱλ��+1�ж���һ���ַ�
			sb.append(commonPrefix);
		}

		return sb.toString();
	}
}
