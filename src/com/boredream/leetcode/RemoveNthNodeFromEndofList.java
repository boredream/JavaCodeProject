package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.boredream.entity.ListNode;

public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5 };
		ListNode head = ListNode.array2nodelist(array);
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
		return ListNode.array2nodelist(array);
	}
}
