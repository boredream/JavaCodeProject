package com.boredream.sword2offer;

import com.boredream.entity.ListNode;

public class Test15FindLastNoListNode {

    /**
     * 输入一个键表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，
     * 本题从1开始计数，即链表的尾结点是倒数第1个结点．例如一个链表有6个结点，
     * 从头结点开始它们的值依次是1、2、3、4、5 6。这个链表的倒数第3个结点是值为4的结点．
     *
     * @param head 链表的头结点
     * @param k    倒数第k个结点
     * @return 倒数第k个结点
     */
    public static ListNode findKthToTail(ListNode head, int k) {
        if(head == null || k < 1) return null;

        ListNode node = head;
        int index = 0;
        int count = 0;
        while(head != null) {
            count ++;
            if(index >= k) {
                node = node.next;
            }
            head = head.next;
            index ++;
        }

        return count < k ? null : node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode();
        head.next.val = 2;
        head.next.next = new ListNode();
        head.next.next.val = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.val = 4;
        head.next.next.next.next = new ListNode();
        head.next.next.next.next.val = 5;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.val = 6;
        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.val = 7;
        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.val = 8;
        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.val = 9;
        System.out.println(findKthToTail(head, 1).val); // 倒数第一个
        System.out.println(findKthToTail(head, 5).val); // 中间的一个
        System.out.println(findKthToTail(head, 9).val); // 倒数最后一个就是顺数第一个
        System.out.println(findKthToTail(head, 10));
    }

}
