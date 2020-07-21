package com.boredream.entity;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode head = this;
        if (hasCycle(head)) {
            return "circle " + head.val;
        } else {
            StringBuilder sb = new StringBuilder();
            while (head != null) {
                sb.append(head.val).append("->");
                head = head.next;
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
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

    public boolean hasCycle(ListNode head) {
        // 快慢指针，如果追的上就代表有循环
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
