package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2AddTwoNumbers {

    public static void main(String[] args) {
        Integer[] array1 = {5};
        Integer[] array2 = {5};

        ListNode node1 = ListNode.array2nodelist(array1);
        ListNode node2 = ListNode.array2nodelist(array2);

        System.out.println(addTwoNumbers2(node1, node2));
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 思路1：因为是逆着，所以正常从头到尾遍历累加就行了，注意递进数字1

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode root = new ListNode();
        ListNode node = root;

        int high = 0;
        while (l1 != null || l2 != null) {
            node.next = new ListNode();
            node = node.next;

            int sum = 0;
            if (l1 == null) {
                node = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                node = l1;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + high;
                if (sum >= 10) {
                    high = 1;
                    sum -= 10;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            node.val = sum;
        }

        if (high == 1) {
            node.next = new ListNode(1);
        }

        return root.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 从前到后，累加进一位
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int add = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;

            int sum = l1val + l2val + add;
            if (sum >= 10) {
                add = 1;
                sum -= 10;
            } else {
                add = 0;
            }
            cur = cur.next = new ListNode(sum);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (add == 1) {
            cur.next = new ListNode(1);
        }

        return result.next;
    }
}
