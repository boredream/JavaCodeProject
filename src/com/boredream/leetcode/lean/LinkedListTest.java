package com.boredream.leetcode.lean;

/**
 * https://leetcode.com/explore/learn/card/linked-list
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedListTest linkedList = new LinkedListTest(); // Initialize empty LinkedList
        System.out.println(linkedList);
        linkedList.addAtHead(1);
        System.out.println(linkedList);
        linkedList.addAtTail(3);
        System.out.println(linkedList);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList);
        int result = linkedList.get(1);// returns 2
        System.out.println(result);
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList);
        result = linkedList.get(1);     // returns 3
        System.out.println(result);
    }

    private class MyNode {
        public int val;
        public MyNode next;

        public MyNode(int val) {
            this.val = val;
        }
    }

    public MyNode head;
    public int length = 0;

    /**
     * Initialize your data structure here.
     */
    public LinkedListTest() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= length) return -1;

        MyNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyNode oldHead = head;
        if (head == null) {
            head = new MyNode(val);
        }
        head.next = oldHead;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new MyNode(val);
        } else {
            head.next = new MyNode(val);
        }
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) return;

        if (head == null) {
            head = new MyNode(val);
        } else {
            MyNode pre = head;
            MyNode cur = head.next;
            for (int i = 1; i < index; i++) {
                pre = pre.next;
                cur = cur.next;
            }
            MyNode node = new MyNode(val);
            pre.next = node;
            node.next = cur;
        }
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > length || length == 0) return;

        MyNode pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        MyNode cur = pre.next;
        pre.next = cur.next;
        cur.next = null;

        length--;
    }

    @Override
    public String toString() {
        MyNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(",");
            cur = cur.next;
        }
        return sb.length() == 0 ? "null" : sb.deleteCharAt(sb.length() - 1).toString();
    }
}
