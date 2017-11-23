package com.boredream.leetcode;

import com.boredream.entity.ListNode;

/**
 * 给定一个linked list，每两个node交换一次，最终返回结果
 * 比如，
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 你的算法必须使用有限的空间，你不能改变list中的值，只能改变这些node
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4};
        System.out.println(swapPairs(ListNode.array2nodelist(nums)));
    }

    /**
     * 思路，当前node只知道next下一个node，
     *
     * 和答案差不多，但是最后的return还是有问题~ 后面swap不影响，但是前两个swap后，继续return head的话就会少一个
     */
//    static ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null) return head;
//        ListNode first = head;
//        ListNode second = head.next;
//
//        for(;;) {
//            if(first == null || first.next == null) break;
//            ListNode temp = first.next;
//            first.next = temp.next;
//            temp.next = first;
//
//            first = first.next;
//        }
//        return second;
//    }

    static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

}
