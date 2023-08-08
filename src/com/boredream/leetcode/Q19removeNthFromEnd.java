package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Q19removeNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(removeNthFromEnd3(listNode, 1));
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        // 思路1：快慢指针。快指针先走n
        if (n <= 0) return head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (n-- < 0) slow = slow.next;
            fast = fast.next;
        }

        if (n == 0) head = head.next;
        else if (n < 0) slow.next = slow.next.next;
        return head;
    }

    static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;
        if (n <= 0) return head;

        // 第一位有可能删掉，所以前面加个头
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode fastNode = node;
        ListNode slowNode = node;
        int fast = 0;
        while (fastNode != null) {
            // 快指针先前进n次后，慢指针前进。这样快指针前进结束后，慢指针就是倒数第n-1个，再对其删除next操作即可
            if (fast >= n + 1) {
                slowNode = slowNode.next;
            }
            // 快指针依次前进
            fastNode = fastNode.next;
            fast++;
        }
        // fast是size+1，如果n是大于size的，则不会删除
        if (n < fast) {
            slowNode.next = slowNode.next.next;
        }
        return node.next;
    }

    static ListNode removeNthFromEnd3(ListNode head, int n) {
        // 思路：先fast前进n，然后slow开始前进，fast到底后slow就是倒数n个
        ListNode node = new ListNode();
        node.next = head;
        ListNode fast = node;
        ListNode slow = node;
        int step = 0;
        while (true) {
            fast = fast.next;
            if(fast == null) {
                break;
            }
            if (step++ >= n) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return node.next;
    }

}
