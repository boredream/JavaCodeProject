package com.boredream.sword2offer;

import com.boredream.entity.ListNode;

import java.util.Stack;

public class ReversePrintListNode {

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值 
     * 使用栈的方式进行 
     *
     * @param root 链表头结点 
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> nodes = new Stack<>();
        while (root != null) {
            nodes.push(root);
            root = root.next;
        }

        while(!nodes.isEmpty()) {
            ListNode listNode = nodes.pop();
            System.out.print(listNode.val + " ");
        }
    }
    
    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值 
     * 使用栈的方式进行 
     *
     * @param root 链表头结点 
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.next);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        printListInverselyUsingIteration(root);
        System.out.println();
        printListInverselyUsingRecursion(root);
    }
    
}
