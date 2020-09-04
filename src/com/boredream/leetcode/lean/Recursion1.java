package com.boredream.leetcode.lean;

import com.boredream.entity.ListNode;
import com.boredream.entity.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/recursion-i
 */
public class Recursion1 {

    public static void main(String[] args) {
        System.out.println(new Recursion1().swapPairs(ListNode.mock()));
    }

    public void reverseString(char[] s) {
        reverseString(s, 0);
    }

    // 翻转，o1空间
    public void reverseString(char[] s, int start) {
        if (start >= s.length / 2) return;
        char temp = s[start];
        s[start] = s[s.length - 1 - start];
        s[s.length - 1 - start] = temp;
        reverseString(s, start + 1);
    }

    // 两两交换
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
        // 尾递归模式
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList2(next);
        next.next = head;
        head.next = null;
        return newHead;
        // 非尾递归
    }

    // 搜索树中找子树
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val == root.val) return root;
        if (val > root.val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }

    // 杨辉三角某列数字
    private HashMap<String, Integer> map = new HashMap<>();

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex) {
                list.add(1);
            } else {
                String key = rowIndex + "-" + i;
                if (map.containsKey(key)) {
                    list.add(map.get(key));
                } else {
                    // 上一组的 i-1 + i 之和
                    List<Integer> row = getRow(rowIndex - 1);
                    int sum = row.get(i - 1) + row.get(i);
                    list.add(sum);
                    map.put(key, sum);
                }
            }
        }
        return list;
        // TODO: 2020/8/7 超时，剪枝问题
    }

    // 斐波那契数列
    private HashMap<Integer, Integer> iiMap = new HashMap<>();

    public int fib(int N) {
        if (N <= 1) return N;
        if (iiMap.containsKey(N)) return iiMap.get(N);
        int sum = fib(N - 1) + fib(N - 2);
        iiMap.put(N, sum);
        return sum;
    }

    // 爬楼梯。一次可以爬 1 / 2。问多少种方法爬到n。
    public int climbStairs(int n) {
        if (n <= 2) return n;
        if (iiMap.containsKey(n)) return iiMap.get(n);
        int sum = climbStairs(n - 1) + climbStairs(n - 2);
        iiMap.put(n, sum);
        return sum;
    }


    // 尾递归（最后return call 自己） 和 非尾递归的区别
    // 普通递归，会不停的在栈中添加调用方法对应的栈帧。而尾递归则会自动复用。


    // 自定义实现平方。支持小数。2^-2=1/4
    public double myPow(double x, int n) {
        // 2 ^ 4 = 2 ^ 3 * 2
        // 2 ^ -3 = 1/8 = 2 ^ -2 / 2
        if (n == 0) return 1;
        return x * myPow(x, n - 1);
        // TODO: 2020/8/7 <0未考虑，且n-1-1-1时间oN，可以直接n/2/2到oLogN
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            // -n只倒一次，后面都*自动保持分数
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    // 合并俩有序数组
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 开始0。然后每轮0->01 / 1->10的变化。N轮后第K个数是几？
    public int kthGrammar(int N, int K) {
        // 每轮数量double
        if (N <= 2) return K - 1;
//        int pre = kthGrammar(N - 1, (K + 1) / 2);
//        int cur;
//        if(pre == 0) {
//            // pre=0 -> 01
//            cur = K % 2 == 1 ? 0 : 1;
//        } else {
//            // pre=1 -> 10
//            cur = K % 2 == 1 ? 1 : 0;
//        }
//        return cur;
        return (kthGrammar(N - 1, (K + 1) / 2) + K + 1) % 2;
    }

    // 创建1~n的所有排序树的可能结构
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        // 类似排列组合题
        Set<Integer> usedNum = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            usedNum.add(i);
            generateTrees(root, i, n, usedNum);
            usedNum.remove(i);
            list.add(root);
        }
        return list;
    }

    private void generateTrees(TreeNode root, int rootVal, int n, Set<Integer> usedNum) {
        // 左分支可以是 1~rootVal的任意数字
        for (int i = 1; i <= n; i++) {
            if(i == rootVal || usedNum.contains(i)) continue;
            TreeNode node = new TreeNode(i);
            if(i < rootVal) {
                root.left = node;
            } else {
                root.right = node;
            }
            usedNum.add(i);
            generateTrees(node, i, n, usedNum);
            usedNum.remove(i);
        }
        // TODO: 2020/8/7
    }

}
