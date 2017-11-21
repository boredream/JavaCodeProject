package com.boredream.leetcode;

import com.boredream.leetcode.entity.ListNode;

/**
 * 转向链式列表
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(reverseList(listNode));
    }

    static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

}
