package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.ListNode;

import java.util.ArrayList;

/**
 * linked反转成array list
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
        ListNode node = ListNode.array2nodelist(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(printListFromTailToHead2(node));
    }

    private static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        // 思路1：正常遍历然后insert0
        ArrayList<Integer> array = new ArrayList<>();
        while (listNode != null) {
            array.add(0, listNode.val);
            listNode = listNode.next;
        }
        return array;
    }

    private static ArrayList<Integer> array = new ArrayList<>();

    private static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        // 思路2：insert0效率差，后面要后移，用递归反着正常加
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            array.add(listNode.val);
        }
        return array;
    }

}
