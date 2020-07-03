package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.ListNode;

/**
 * 翻转链表
 */
public class ReverseList {

    public static void main(String[] args) {
        // TODO: 2019/1/31
        ListNode head = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(ReverseList3(head));
    }

    private static ListNode ReverseList1(ListNode head) {
        // 思路1：重新建一个~ 先遍历，值塞到栈里，然后先进后出反过来新建一个新的。 但是太low 先PASS
        return null;
    }

    private static ListNode ReverseList2(ListNode head) {
        // 思路2：翻转的话，递归？
        if(head.next == null) return head;
        head.next = ReverseList2(head.next);
        return head.next;
    }

    private static ListNode ReverseList3(ListNode head) {
        // 思路3：网上的 喵喵喵？
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
