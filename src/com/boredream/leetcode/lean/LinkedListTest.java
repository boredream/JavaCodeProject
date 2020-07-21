package com.boredream.leetcode.lean;

import com.boredream.entity.ListNode;

/**
 * https://leetcode.com/explore/learn/card/linked-list
 */
public class LinkedListTest {

    public static void main(String[] args) {
        ListNode node = ListNode.array2nodelist(new Integer[]{3});
        System.out.println(new LinkedListTest().detectCycle(node));
    }

    // 判断是否有循环
    public boolean hasCycle(ListNode head) {
        // 快慢指针，如果追的上就代表有循环
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

    // 找到循环开始点
    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        // 找到重合点后，fast比slow多跑一个循环
        // 开始到循环起点A，循环起点到交汇点B，交汇点循环到起点为C
        // 所以第一次交汇 slow=A+B，fast=A+B+C，又因为速度是两倍 2(A+B)=A+B+C，得到A=C
        // 因此在第一次交汇后，重新让一个点从开始，另一个店从交汇处，都前进A=C就会一起到达B点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
