package com.boredream.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ValidParentheses {
	public static void main(String[] args) {
		String s = "{}";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		if(s == null) {
			return false;
		}
		
		List<Character> allParentheses = Arrays.asList(
				new Character[]{ '(', '[', '{', ')', ']', '}'  });
		LinkedList<Character> leftRemainder = new LinkedList<>();
		
		for(char c : s.toCharArray()) {
			int index = allParentheses.indexOf(c);
			if(index == -1) {
				continue;
			}
			
			int lastLeftIndex = 999;
			if(leftRemainder.size() > 0) {
				lastLeftIndex = allParentheses.indexOf(leftRemainder.getLast());
			}
			
			if(index <= 2) {
				// left, add it
				leftRemainder.add(c);
			} else {
				// right, check left remainder
				if(index - lastLeftIndex == 3) {
					leftRemainder.removeLast();
				} else {
					leftRemainder.add(c);
					break;
				}
			}
		}
		
		return leftRemainder.size() == 0;
	}
}
