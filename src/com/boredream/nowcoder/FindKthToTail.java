package com.boredream.nowcoder;

import com.boredream.entity.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public static void main(String[] args) {
        System.out.println(FindKthToTail(ListNode.array2nodelist(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}), 3).val);
    }

    static ListNode FindKthToTail(ListNode head, int k) {
        if(k <= 0) return null;

        int k1 = 0;
        ListNode node = head;
        ListNode result = null;
        while(node != null) {
            k1++;
            if(k1 >= k) {
                if(result == null) {
                    result = head;
                } else {
                    result = result.next;
                }
            }
            node = node.next;
        }

        return result;
    }

}
