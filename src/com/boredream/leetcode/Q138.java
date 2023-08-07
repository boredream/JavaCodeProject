package com.boredream.leetcode;

import com.boredream.entity.ListNode;
import com.boredream.entity.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * <p>
 * 提示：
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random 为 null 或指向链表中的节点。
 *
 * TODO 有更节省空间时间的做法
 */
public class Q138 {

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node3;
        node4.random = node3;
        node5.random = node1;

        Node copyNode = copyRandomList(node1);
        System.out.println(copyNode);
    }

//    static Node copyRandomList(Node head) {
//        // 思路：next拷贝比较简单。如何处理random呢？hash map？
//        Node node = new Node(0);
//        Node cur = node;
//        HashMap<Node, Node> map = new HashMap<>();
//        while (head != null) {
//            cur.next = new Node(head.val);
//            cur = cur.next;
//            map.put(cur, head.random);
//            head = head.next;
//        }
//        cur = node.next;
//        while(cur != null) {
//            cur.random = map.get(cur);
//            cur = cur.next;
//        }
//        // FIXME: 2023/8/7 不行，因为hash在遍历过程中，保存的value是指向原始node的random节点。
//        return node.next;
//    }

    static Node copyRandomList(Node head) {
        // 思路：next拷贝比较简单。如何处理random呢
        // 因为random是个指针，指向的是地址，所以原始节点上的关系无法直接映射到新节点上
        // 那怎么办呢？指针变集合？通过索引记录random关系？
        Node originNode = head;
        Node copyNode = new Node(0);
        Node curCopyNode = copyNode;
        ArrayList<Node> copyNodeList = new ArrayList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        int index = 0;
        while (originNode != null) {
            // 第一遍循环，拷贝next，并且记录节点+索引
            curCopyNode.next = new Node(originNode.val);
            curCopyNode = curCopyNode.next;
            copyNodeList.add(curCopyNode);

            map.put(originNode, index++);
            originNode = originNode.next;
        }

        originNode = head;
        curCopyNode = copyNode.next;
        while (originNode != null) {
            // 第二遍循环，记录random和索引关系
            Integer randomIndex = map.get(originNode.random);
            if(randomIndex != null) {
                curCopyNode.random = copyNodeList.get(randomIndex);
            }
            originNode = originNode.next;
            curCopyNode = curCopyNode.next;
        }
        return copyNode.next;
    }

}
