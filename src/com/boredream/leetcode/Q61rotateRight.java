package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Q61rotateRight {
    public static void main(String[] args) {
        ListNode node = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(rotateRight(node, 11111));
    }

    static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        // 思路，第一遍循环获取长度。k%length，中间截断重新拼接
        ListNode node = head;
        ListNode last = head;
        int count = 0;
        while(node != null) {
            node = node.next;
            if(count > 0) {
                last = last.next;
            }
            count ++;
        }
        k = k % count;
        if(k == 0) return head;

        // 前后双指针前进，到达k后，先到的是right，后到的是left，重新拼接
        ListNode left = head;
        ListNode right = head;
        for (int i = count - k; i > 0; i--) {
            if(i != k) {
                left = left.next;
            }
            right = right.next;
        }
        left.next = null;
        last.next = head;

        return right;
    }
}
