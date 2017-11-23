package com.boredream.nowcoder;

import com.boredream.entity.ListNode;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class printListFromTailToHead {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7};
        ArrayList<Integer> list = printListFromTailToHead(ListNode.array2nodelist(ints));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * 递归的方式一层层下去，然后back倒序一个一个加到集合里
     */
    static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

}
