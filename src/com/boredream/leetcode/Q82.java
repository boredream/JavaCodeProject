package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Q82 {
    public static void main(String[] args) {
        System.out.println(deleteDuplicates(ListNode.array2nodelist(new Integer[]{1, 1, 2, 3, 3, 4})));
    }

    static ListNode deleteDuplicates(ListNode head) {
        // 思路：以当前节点为锚，对比下一个节点和当前是否相等，直到找到不相等的（或者到底了），连接之
        if(head.next == null) {
            return head;
        }
        ListNode start = head;
        ListNode node = head.next;
        while (node != null) {
            if (start.val == node.val) {
                // 只要相等，就挪动指针
                start.next = node.next;
            } else {
                // 如果不相等，则start更新
                start = node;
            }
            node = node.next;
        }
        // TODO: chunyang 2023/8/8 题目理解错误，重复的全删了，而不是只保留一个
        return head;
    }

}
