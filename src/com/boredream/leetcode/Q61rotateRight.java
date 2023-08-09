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
        ListNode node = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(rotateRight1(node, 2));
    }

    static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        // 思路，第一遍循环获取长度。k%length，中间截断重新拼接
        ListNode node = head;
        ListNode last = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            if (count > 0) {
                last = last.next;
            }
            count++;
        }
        k = k % count;
        if (k == 0) return head;

        // 前后双指针前进，到达k后，先到的是right，后到的是left，重新拼接
        ListNode left = head;
        ListNode right = head;
        for (int i = count - k; i > 0; i--) {
            if (i != k) {
                left = left.next;
            }
            right = right.next;
        }
        left.next = null;
        last.next = head;

        return right;
    }

    static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 思路：123456789+2 最终会转为891234567，即找到倒数第k+1=3位置的node进行截断，再找到末尾的node重新拼接即可
        // 双指针，类似删除倒数n的思路，fast先前进k，slow再开始

        // 循环的情况
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        k %= count;
        if (k == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        // 由于需要保留末节点拼接用，所以判断next非空
        while (fast.next != null) {
            if (--k < 0) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
        // TODO: chunyang 2023/8/9 优化。因为可能k>n，所以会循环一次然后%，因此可以获取n，就不完全用类似删除倒数k的情况了。
    }

}
