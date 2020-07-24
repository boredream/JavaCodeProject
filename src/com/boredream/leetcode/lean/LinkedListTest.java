package com.boredream.leetcode.lean;

import com.boredream.entity.ListNode;

/**
 * https://leetcode.com/explore/learn/card/linked-list
 */
public class LinkedListTest {

    public static void main(String[] args) {
        ListNode nodeA = ListNode.array2nodelist(new Integer[]{1,2});
        System.out.println(new LinkedListTest().isPalindrome(nodeA));
    }

    // 判断是否有循环
    public boolean hasCycle(ListNode head) {
        // 快慢指针，如果追的上就代表有循环
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
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
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    // 找到俩链表交叉点，oN时间 + o1空间，不能破坏原有结构
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 空间o1不能hash了。
        // 从后向前，不相等的时候就是分叉处？但是如何后向前
        // 或 先遍历俩次获取长度，然后对齐前进，后面如果全相等，则交叉
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        int lengthA = 0;
        while (a != null) {
            lengthA++;
            a = a.next;
        }

        ListNode b = headB;
        int lengthB = 0;
        while (b != null) {
            lengthB++;
            b = b.next;
        }

        if (lengthA < lengthB) {
            for (int i = 0; i < lengthB - lengthA; i++) {
                headB = headB.next;
            }
        } else if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        }

        while (headA != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
        // TODO: 2020/7/22 https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
        // 牛逼答案，思路类似。但利用 lengthA + lengthB = lengthB + lengthA 的思路。
        // 双指针开始A、B，如果长度相等最后null相等，结束循环。
        // 如果长度不等，末尾判断null交换指针跑两轮，A+B=B+A第二轮一定长度相等一起跑到末尾，得出判断。
    }

    // 删除倒数第n个node
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        if (n <= 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while (fast != null) {
            fast = fast.next;
            if (length++ > n) {
                slow = slow.next;
            }
        }
        if (n > length) return head;
        if (n == length) return head.next;
        slow.next = slow.next.next;
        return head;
        // TODO: 2020/7/22 可以不用length，先让fast先跑n，如果n超过length可以直接处理
    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        // 教程思路，head不停的和next替换，交换后指向next.next，交换的next放到头部
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        pre.next = head;
        while (head.next != null) {
            // pre 0, *head 1, next 2, next.next 3

            // next.next 3
            ListNode tail = head.next.next;

            // head的下一个，变成新header（pre.next），插到oldHead前面
            // pre 0, next 2, *header 1 ...
            ListNode oldHead = pre.next;
            pre.next = head.next;
            pre.next.next = oldHead;

            // 当前head.next后移一位
            // // pre 0, next 2, *header 1, next.next 3
            head.next = tail;
        }
        return pre.next;
    }

    // 翻转链表
    public ListNode reverseList1(ListNode head) {
        // TODO: 2020/7/22 网上方案，直接交换head和头部，然后head后移。我自己的方案是交换head.next和head
        // 教程思路，head不停的和next替换，交换后指向next.next，交换的next放到头部
        ListNode preHead = null;
        while (head != null) {
            // 记录head尾巴
            ListNode recordHead = head.next;
            // 将head交换到新头部，然后连接原有的头部作为尾巴，产生新头部
            // 第一次比较特殊，原有头部是null，所以只把第一个head数字截出来作为尾巴
            head.next = preHead;
            preHead = head;
            // 原有head后移一位
            head = recordHead;
        }
        return preHead;
    }

    // 翻转链表
    public ListNode reverseList2(ListNode head) {
        // TODO: 2020/7/22 网上方案，递归方案
        // TODO: 2020/7/22 暂时不理解
        if (head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseList2(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

    // 删除所有val值的node
    public ListNode removeElements(ListNode head, int val) {
        // 先删除开头x个val值
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    // 删除所有val值的node
    public ListNode removeElements1(ListNode head, int val) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
        // TODO: 2020/7/22 还有递归方式
    }

    // 重组数组，让奇数位在前，偶数位在后（第几位的奇偶，不是val值的奇偶）。oN时间 + o1空间
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 1,2,3,4,5,6,7 -> 1,3,5,7 , 2,4,6
        // next前进一次保留，再一次放在tail里，结束俩拼一起
        ListNode curOdd = head;
        ListNode even = head.next;
        ListNode curEven = even;
        while (curEven != null && curEven.next != null) {
            // 跳一格
            curOdd.next = curOdd.next.next;
            curEven.next = curEven.next.next;
            curOdd = curOdd.next;
            curEven = curEven.next;
        }
        curOdd.next = even;
        return head;
        // TODO: 2020/7/24 代码简单，双指针不影响的关系需要梳理理解
    }

    // 判断是否是回文，oN时间 + o1空间
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 2,3,2是回文，1,2,3,2,1也是回文，dp？ 单链路，不行
        // o1空间，hash也不行
        // 直接reverse再挨个对比，保留原有数据要oN空间

        // 第一轮获取长度，然后reverse后拆成一半，挨个对比
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        // TODO: 2020/7/24 直接快慢指针，快的2step，慢的1step，快的结束时，慢的定位到中间位置，直接二分后翻转比较。

        ListNode newHead = null;
        int index = 0;
        while (head != null) {
            ListNode recordHead = head.next;
            head.next = newHead;
            newHead = head;
            head = recordHead;
            if (++index >= length / 2) {
                break;
            }
        }

        if (length % 2 == 1) {
            head = head.next;
        }
        while (head != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
