package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Q86 {
    public static void main(String[] args) {
        ListNode node = ListNode.array2nodelist(new Integer[]{2,1});
        System.out.println(partition(node, 2));
    }

    static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return null;
        }
        // 思路：小于x的挪到左边，其它的挪到右边，链表无序，重新拼接后会打乱
        // 循环的时候先把>=x的删掉拿出来，单独拼成一个链表，最后拼在末尾
        ListNode right = new ListNode();
        ListNode rightEnd = right;
        ListNode node = head;
        while (node.next != null) {
            if(node.next.val >= x) {
                // 如果下一个值>=x，记录到单独链表上
                rightEnd.next = node.next;
                rightEnd = rightEnd.next;
                // 删除中间节点
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        // 最后把rightEnd尾节点的next清除，然后重新拼接
        rightEnd.next = null;
        node.next = right.next;
        return head;
        // FIXME: 2023/8/9 首位可能是>=x的，不通过
    }

}
