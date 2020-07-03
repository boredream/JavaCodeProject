package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Q24swapPairs {

    public static void main(String[] args) {
        System.out.println(swapPairs(ListNode.array2nodelist(new Integer[]{1, 2, 3, 4})));
    }

    static ListNode swapPairs(ListNode head) {
        // 思路1：node的change算法。
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode cur = node;

        for (int count = 0; cur.next != null && cur.next.next != null; count++) {
            if (count % 2 != 1) {
                ListNode first = cur.next;
                ListNode temp = first.next;
                first.next = first.next.next;
                temp.next = first;
                cur.next = temp;
            }
            cur = cur.next;
        }
        return node.next;
    }

}
