package com.boredream;

public class StringToInteger {
	public static void main(String[] args) {
		// �Ѷ�Easy, ���Ǹ��ֿ�
		// +-����,�Լ��ո�,��ΧԽ���ȡ�߽�ֵ������ȡ0...
		String s = "  - 321";
		System.out.println(myAtoi(s));
	}

	public static int myAtoi(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}

		int result = 0;
		StringBuilder sb = new StringBuilder();
		int negativeStatus = 0;
		for (char c : str.toCharArray()) {
			if (sb.length() == 0) {
				if (c == ' ' && negativeStatus == 0) {
					continue;
				}

				if (negativeStatus == 0) {
					if (c == '-') {
						negativeStatus = -1;
						continue;
					} else if (c == '+') {
						negativeStatus = 1;
						continue;
					}
				}
			}

			if (c < '0' || c > '9') {
				break;
			}

			sb.append(c);

			try {
				long longData = Long
						.parseLong((negativeStatus == -1 ? "-" : "")
								+ sb.toString());
				if (longData >= Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (longData <= Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			} catch (Exception e) {
				break;
			}
		}

		if (sb.length() > 0) {
			if (negativeStatus == -1) {
				sb.insert(0, "-");
			}
			result = Integer.parseInt(sb.toString());
		}

		return result;
	}
}
