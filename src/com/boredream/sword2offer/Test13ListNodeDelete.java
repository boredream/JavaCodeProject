package com.boredream.sword2offer;

import com.boredream.entity.ListNode;

public class Test13ListNodeDelete {
    /**
     * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点, 
     * 【注意1：这个方法和文本上的不一样，书上的没有返回值，这个因为JAVA引用传递的原因， 
     * 如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了】 
     * 【注意2：输入的待删除结点必须是待链表中的结点，否则会引起错误，这个条件由用户进行保证】 
     *
     * @param head        链表表的头 
     * @param toBeDeleted 待删除的结点 
     * @return 删除后的头结点
     */
    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        // 无内容要删，或者本身自己就是空的，返回header自己
        if(head == null || toBeDeleted == null) return head;

        // 如果要删去头，则返回余下部分
        if(head == toBeDeleted) return head.next;

        // 错误！！！直接就换引用了，应该直接改value，指针只能改next的next
//        if(toBeDeleted.next != null) {
//            toBeDeleted = toBeDeleted.next;
//        }

        // 应该改当前的value，然后next改成next的next，等于把下一个删掉，
        // 但是下一个值赋给了自己~ 相当于把寄几给删了
        if(toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        } else {
            // next为空，可能是最后一个，也可能不在链中
            ListNode temp = head;
            while(temp.next != toBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
        }

        return head;
    }
    /**
     * 输出链表的元素值 
     *
     * @param head 链表的头结点 
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
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
        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.val = 5;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.val = 6;
        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.val = 7;
        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.val = 8;
        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.val = 9;
        head = deleteNode(head, null); // 删除的结点为空  
        printList(head);
        ListNode node = new ListNode();
        node.val = 12;
        head = deleteNode(head, head); // 删除头结点  
        printList(head);
        head = deleteNode(head, last); // 删除尾结点  
        printList(head);
        head = deleteNode(head, middle); // 删除中间结点  
        printList(head);
        head = deleteNode(head, node); // 删除的结点不在链表中  
        printList(head);
    }
}  