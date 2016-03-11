package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5 };
		ListNode head = array2nodelist(array);
		System.out.println(removeNthFromEnd(head, 6));
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (n < 1) {
			return head;
		}

		List<Integer> values = new ArrayList<>();
		ListNode node = head;
		while (true) {
			values.add(node.val);
			ListNode next = node.next;
			if (next == null) {
				break;
			}

			node = next;
		}

		if (n > values.size()) {
			return head;
		}

		values.remove(values.size() - n);
		Integer[] array = values.toArray(new Integer[values.size()]);
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
