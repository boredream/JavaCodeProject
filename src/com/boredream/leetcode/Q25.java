package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
public class Q25 {

    public static void main(String[] args) {
        System.out.println(reverseKGroup(ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}), 2));
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        // 思路：类似Q92区间翻转，按照 %k 0~k 位置不停翻转即可
        if(k == 1) {
            return head;
        }

        // 获取长度
        ListNode node = head;
        int count = 0;
        while(node != null) {
            node = node.next;
            count ++;
        }

        // 前面拼一个
        ListNode result = new ListNode();
        result.next = head;
        ListNode preHead = result;
        node = result.next;

        // 循环次数
        int loop = count / k;
        for (int i = 0; i < loop; i++) {
            // 循环n次
            ListNode first = node;
            ListNode pre = null;
            for (int j = 0; j < k; j++) {
                // 每次翻转k个数
                ListNode next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            // 反转结束后，pre就是新的翻转链表，拼在 preHead 后面
            preHead.next = pre;
            // 然后翻转前的第一个节点，即现在pre的末尾节点，作为新一轮的preHead
            preHead = first;

            // 把末尾拼接上
            if(i == loop - 1 && node != null) {
                first.next = node;
            }
        }
        return result.next;
    }

}
