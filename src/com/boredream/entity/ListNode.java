package com.boredream.entity;


public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
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
}
