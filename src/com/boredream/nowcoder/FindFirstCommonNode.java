package com.boredream.nowcoder;

import com.boredream.entity.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 公共节点的意思是从这个单开始，两个表后面每个点值都相等
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {
        ListNode node1 = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListNode node2 = ListNode.array2nodelist(new Integer[]{11, 12, 13, 14, 7, 8, 9});
    }

    static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        return null;
    }

}
