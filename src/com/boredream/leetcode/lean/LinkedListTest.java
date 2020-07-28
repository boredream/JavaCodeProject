package com.boredream.leetcode.lean;

import com.boredream.entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/learn/card/linked-list
 */
public class LinkedListTest {

    public static void main(String[] args) {
//        ListNode nodeB = ListNode.array2nodelist(new Integer[]{1});
        for (int i = 0; i < 11; i++) {
            ListNode nodeA = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5});
            System.out.println(new LinkedListTest().rotateRight(nodeA, i));
        }
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

    // 合并俩有序链表成新的有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node = new ListNode();
        ListNode cur = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else if (l2 != null) cur.next = l2;
        return node.next;
    }

    // 合并俩有序链表成新的有序链表
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 递归
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    // 链表加和。1->2->3 = 321
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode();
        addTwoNumbers(node, l1, l2, 0);
        return node.next;
    }

    public void addTwoNumbers(ListNode node, ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null && add == 0) return;
        int sum = add;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;
        node.next = new ListNode(sum % 10);
        addTwoNumbers(node.next, l1 != null ? l1.next : null, l2 != null ? l2.next : null, sum / 10);
    }

    // 带child的node，树状装换为大平层
    static class ChildNode {
        public ChildNode(int val) {
            this.val = val;
        }

        public int val;
        public ChildNode prev;
        public ChildNode next;
        public ChildNode child;
    }

    // 递归方案
    public ChildNode flatten(ChildNode head) {
        flattenTail(head);
        return head;
    }

    // 向next or child探索，直到最后一个元素，返回
    public ChildNode flattenTail(ChildNode head) {
        if (head == null) return head;

        ChildNode next = head.next;
        ChildNode child = head.child;

        if (child != null) {
            // 有child，找到child末尾
            ChildNode tail = flattenTail(child);

            // 当前和child重连
            head.next = child;
            child.prev = head;

            // 如果还有next，将child末尾后面再连上next，然后继续向next探索
            if (next != null) {
                tail.next = next;
                next.prev = tail;
                return flattenTail(next);
            }

            return tail;
        } else {
            // 没child+没next=末尾
            if (head.next == null) return head;
            // 向next探索
            return flattenTail(head.next);
        }
        // TODO: 2020/7/27 非递归方式
    }

    static class RandomNode {
        int val;
        RandomNode next;
        RandomNode random;

        public RandomNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 拷贝node，包含所有next+random关系
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        // next简单，如何找random？第一轮记录指向的node index，第二轮再？
        // TODO: 2020/7/28 借助 hash map ？未复写hash code的默认依据地址生成

        // 原有-新
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }

        // 链接
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);

        // TODO: 2020/7/28 大神解法，所有元素copy后一位，1-2-3 -> 1-1-2-2-3-3，然后 next.random = random.next
        // https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
    }

    // 向后一位循环转动
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        // 找到倒数第k的位置，后半截在前，前半截在后。
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;
        // 1-2-3-4-5 k=2 -> 4-5- 1-2-3
        // k 可能超过size，则第一轮记录length，再重新跑
        int length = 0;
        while (fast != null) {
            if (k-- < 0) {
                slow = slow.next;
            }

            if(fast.next == null) {
                last = fast;
            }

            length++;
            fast = fast.next;

            // 如果到底了，k还没结束，则重头开始，且k取长度余数
            if(fast == null && k > 0) {
                k %= length;
                if(k == 0) break;
                fast = head;
            }
        }

        if(k % length == 0) return head;

        ListNode tail = slow.next;
        slow.next = null;
        last.next = head;
        return tail;
        // TODO: 2020/7/28 没必要一次循环，先第一轮获取length，然后再第二轮后拼接代码更简略
    }

}
