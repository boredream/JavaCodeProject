package com.boredream.sword2offer;

import com.boredream.entity.ListNode;

public class Test17Combine2SortLinkedList {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode node = new ListNode();
        ListNode end = node;
        while(head1 != null && head2 != null) {
            // 都没到头，比较谁大
            if(head1.val < head2.val) {
                end.next = head1;
                head1 = head1.next;
            } else {
                end.next = head2;
                head2 = head2.next;
            }
            end = end.next;
        }

        // 下面的两个if有且只一个if会内的内容会执行
        // 如果第一个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head1 != null) {
            end.next = head1;
        }
        // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head2 != null) {
            end.next = head2;
        }

        return node.next;
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
        ListNode head2 = new ListNode();
        head2.val = 1;
        head2.next = new ListNode();
        head2.next.val = 3;
        head2.next.next = new ListNode();
        head2.next.next.val = 5;
        head2.next.next.next = new ListNode();
        head2.next.next.next.val = 6;
        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.val = 7;
        head = merge(head, head2);
        System.out.println(head);
    }
}