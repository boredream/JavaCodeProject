package com.boredream.sword2offer;

import com.boredream.entity.ListNode;

public class Test16RevListNode {

    // FIXME: 2017/12/15 重点！！！！！！！！！！！！！1

    /**
     * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
     *
     * @param head 链表的头结点
     * @return 反转后的链表的头结点
     */
    public static ListNode reverseList(ListNode head) {
        // 创建一个临时结点，当作尾插法的逻辑头结点
        ListNode root = new ListNode();
        // 逻辑头结点点的下一个结点为空
        root.next = null;
        // 用于记录要处理的下一个结点
        ListNode next;
        // 当前处理的结点不为空
        while (head != null) {
            // 记录要处理的下一个结点
            next = head.next;
            // 当前结点的下一个结点指向逻辑头结点的下一个结点
            head.next = root.next;
            // 逻辑头结点的下一个结点指向当前处理的结点
            root.next = head;
            // 上面操作完成了一个结点的头插
            // 当前结点指向下一个要处理的结点
            head = next;
        }
        // 逻辑头结点的下一个结点就是返回后的头结点
        return root.next;
    }

    public static ListNode reverseList2(ListNode head) {
        // 临时节点
        ListNode temp = new ListNode();

        while(head != null) {
            // 新建一个node，值设为当前head值，next设为temp的next
            ListNode node = new ListNode();
            node.val = head.val;
            node.next = temp.next;
            // 设置好后，在把他作为temp的next覆盖回去，完成前插操作
            temp.next = node;

            head = head.next;
        }

        return temp.next;
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
        System.out.println(head);
        head = reverseList(head);
        System.out.println(head);
        head = reverseList2(head);
        System.out.println(head);
    }
}