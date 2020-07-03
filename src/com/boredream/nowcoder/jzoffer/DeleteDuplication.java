package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public static void main(String[] args) {
        ListNode node = ListNode.array2nodelist(new Integer[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println(deleteDuplication(node));
    }

    static ListNode deleteDuplication(ListNode pHead) {
        // 思路1：双指针，前后差一位。每次后一位判断当前和next是否相同，相等就让后一位的next = next.next，然后继续判断。直到不同时，把重复next自己也删了。
        if(pHead == null || pHead.next == null) return pHead;

        ListNode first = new ListNode();

        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p!= null&&p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }

}
