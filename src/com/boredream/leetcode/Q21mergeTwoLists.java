package com.boredream.leetcode;

import com.boredream.entity.ListNode;

public class Q21mergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = ListNode.array2nodelist(new Integer[]{1, 2, 4});
        ListNode l2 = ListNode.array2nodelist(new Integer[]{1, 3, 4});
//        System.out.println(mergeTwoLists(l1, l2));
        System.out.println(mergeTwoLists2(l1, l2));
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 思路1：俩都是有序，新建个链表，双指针递进，小的节点先加入。
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode();
        ListNode next = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // 使用小的那个
                next.next = l1;
                l1 = l1.next;
            } else {
                next.next = l2;
                l2 = l2.next;
            }

            next = next.next;
        }

        if (l1 == null) {
            next.next = l2;
        } else {
            next.next = l1;
        }

        return node.next;
    }

    static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        // 思路：俩数据对比，谁小先排谁
        ListNode node = new ListNode();
        ListNode cur = node;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return node.next;
    }
}
