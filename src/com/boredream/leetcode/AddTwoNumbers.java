package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
	public static void main(String[] args) {
		Integer[] array1 = { 5 };
		Integer[] array2 = { 5 };

		ListNode node1 = array2nodelist(array1);
		ListNode node2 = array2nodelist(array2);

		System.out.println(addTwoNumbers(node1, node2));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> valList = new ArrayList<>();

		boolean add = false;
		for (;;) {
			if (l1 == null && l2 == null && !add) {
				break;
			}

			int val1 = 0;
			if (l1 != null) {
				val1 = l1.val;
				l1 = l1.next;
			}

			int val2 = 0;
			if (l2 != null) {
				val2 = l2.val;
				l2 = l2.next;
			}

			int sum = val1 + val2;
			if (add) {
				sum++;
				add = false;
			}

			if (add = (sum >= 10)) {
				sum -= 10;
			}

			valList.add(sum);
		}

		Integer[] array = valList.toArray(new Integer[valList.size()]);
		return array2nodelist(array);
	}

	public static ListNode array2nodelist(Integer[] array) {
		ListNode nextNode = null;
		for (int i = array.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(array[i]);
			if (nextNode != null) {
				node.next = nextNode;
			}
			nextNode = node;
		}
		return nextNode;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}

	}
}
