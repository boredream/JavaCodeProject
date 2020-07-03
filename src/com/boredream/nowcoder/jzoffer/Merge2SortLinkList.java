package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge2SortLinkList {

    // TODO: 2019/2/1 还是没太理解算法

    public static void main(String[] args) {
        ListNode list1 = ListNode.array2nodelist(new Integer[]{1, 3, 5, 7, 9});
        ListNode list2 = ListNode.array2nodelist(new Integer[]{2, 4, 6, 8});
        System.out.println(Merge1(list1, list2));
    }

    private static ListNode Merge1(ListNode list1, ListNode list2) {
        // 思路1：新建一个list，然后遍历俩list1，对比谁小谁先插入；
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // 新建一个头节点，用来存合并的链表。
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode root = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                head = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }
        // 把未结束的链表连接到合并后的链表尾部
        if (list1 != null) head.next = list1;
        if (list2 != null) head.next = list2;
        return root.next;
    }

}
