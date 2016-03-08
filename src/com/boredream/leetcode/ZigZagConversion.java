package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public static void main(String[] args) {
		// ��̫��, ��ĿҪ��ֱ������������,�����ɻ���Ҫzigzag��״��������...
		String s = "0123456789";
		System.out.println(convert(s, 4));
	}

	public static String convert(String s, int numRows) {
		if (numRows <= 1) {
			return s;
		}

		List<StringBuilder> zigZagList = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			zigZagList.add(new StringBuilder());
		}

		boolean reverse = false;
		int totalIndex = 0;
		int rowsIndex = 0;
		while (true) {
			StringBuilder rows = zigZagList.get(rowsIndex);
			rows.append(s.charAt(totalIndex));

			totalIndex++;
			if (totalIndex > s.length() - 1) {
				break;
			}

			if (!reverse) {
				// ˳��
				rows.append(genSpace(numRows - 2 - rowsIndex));

				rowsIndex++;
				if (rowsIndex == numRows - 1) {
					reverse = !reverse;
				}
			} else {
				// ����
				rows.append(genSpace(rowsIndex - 1));

				rowsIndex--;
				if (rowsIndex == 0) {
					reverse = !reverse;
				}
			}
		}

		StringBuilder resultSb = new StringBuilder();
		for (int i = 0; i < zigZagList.size(); i++) {
			StringBuilder sb = zigZagList.get(i);
			if (sb.length() == 0) {
				break;
			}

			if (i > 0) {
				resultSb.append("\n");
			}
			resultSb.append(sb);
		}

		return resultSb.toString();
	}

	private static String genSpace(int spaceCount) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < spaceCount; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
