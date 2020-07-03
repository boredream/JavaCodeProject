package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public static void main(String[] args) {
        ListNode head = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(FindKthToTail1(head, 10));
    }

    private static ListNode FindKthToTail1(ListNode head, int k) {
        // 思路1：快慢指针
        if (head == null || k <= 0) return null;
        int high = 0;
        ListNode low = head;
        while (head != null) {
            if (high++ >= k) {
                low = low.next;
            }
            head = head.next;
        }
        if (k > high) return null;
        return low;
    }

}
