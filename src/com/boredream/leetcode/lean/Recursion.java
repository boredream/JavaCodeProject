package com.boredream.leetcode.lean;

import com.boredream.entity.ListNode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i
 */
public class Recursion {

    public static void main(String[] args) {
        ListNode node = ListNode.array2nodelist(new Integer[]{1,2,3,4});
        System.out.println(new Recursion().reverseList(node));
    }

    public void reverseString(char[] s) {
        reverseString(s, 0);
    }

    // 翻转，o1空间
    public void reverseString(char[] s, int start) {
        if (start >= s.length / 2) return;
        char temp = s[start];
        s[start] = s[s.length - 1 - start];
        s[s.length - 1 - start] = temp;
        reverseString(s, start + 1);
    }

    // 两两交换
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        // swap
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;

        // recursion
        newHead.next.next = swapPairs(newHead.next.next);

        return newHead;
        // TODO: 2020/8/6 swap 和 recursion 可以结合
    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        // TODO: 2020/8/6 不交换，head一直next向后，然后前面截断，一个一个插入到新node里，最终返回
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode newHead) {
        if(head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }
}
