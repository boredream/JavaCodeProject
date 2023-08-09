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
        System.out.println(deleteDuplicates1(ListNode.array2nodelist(new Integer[]{1, 1})));
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

    static ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // 思路：需要把重复数字全部删除，就要记录重复数字的前一个节点
        ListNode result = new ListNode(200);
        result.next = head;

        // pre是重复节点的前一个
        ListNode pre = result;
        ListNode node = head;
        boolean isDeleteFlag = false;
        while (node != null) {
            if (node.next != null) {
                if (node.val != node.next.val) {
                    // 如果当前数字和next不一样，更新pre
                    if (isDeleteFlag) {
                        // 如果当前node是重复情况，pre的next指向当前节点的next
                        pre.next = node.next;
                        isDeleteFlag = false;
                    } else {
                        // 如果当前不是重复情况，pre的next指向当前节点
                        pre.next = node;
                        pre = node;
                    }
                } else {
                    // 如果一样
                    isDeleteFlag = true;
                }
            }
            node = node.next;
        }
        if(isDeleteFlag) {
            // 后面全重复
            pre.next = null;
        }
        return result.next;
        // TODO: chunyang 2023/8/9 逻辑想复杂了，其实可以判断下个节点和下下个节点，这样就能针对当前这个重复前节点进行next操作了
    }

}
