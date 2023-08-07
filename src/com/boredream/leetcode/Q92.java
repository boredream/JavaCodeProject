package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class Q92 {

    public static void main(String[] args) {
        System.out.println(reverseBetween(ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5, 6, 7}), 1, 7));
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {
        // 思路：根据基本的翻转算法，加上区间限制
        ListNode node = new ListNode();
        node.next = head;
        ListNode cur = node;

        ListNode pre = null;
        ListNode start = left == 0 ? head : null;
        ListNode end = null;
        int index = 0;
        while (cur != null) {
            ListNode next = cur.next;
            if (index == left - 1) {
                // 前一个节点作为起始点
                start = cur;
                end = start.next;
            } else if (start != null && index <= right) {
                // 开始翻转
                cur.next = pre;
                pre = cur;
                start.next = pre;
            } else if (end != null) {
                // 结束，且还有尾巴
                end.next = cur;
                break;
            }
            cur = next;
            index++;
        }
        return node.next;
    }

}
