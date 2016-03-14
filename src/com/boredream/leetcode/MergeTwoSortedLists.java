package com.boredream.leetcode;


public class MergeTwoSortedLists {
	public static void main(String[] args) {

	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		return null;
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
