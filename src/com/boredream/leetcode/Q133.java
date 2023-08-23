package com.boredream.leetcode;

import java.util.*;

/**
 * 你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * <p>
 * 提示：
 * 节点数不超过 100 。
 * 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 图是连通图，你可以从给定节点访问到所有节点。
 */
public class Q133 {

    // TODO: chunyang 2023/8/23 需要捋一捋

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        cloneGraph(node1);
    }

    static Node cloneGraph(Node node) {
        // 思路：图类似于二叉树，只是单链变成双链，且方向会更无序。
        // 可以WFS。但是注意处理环？则可以用Hash保存已探测数据，防止循环
        HashSet<Integer> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        set.add(node.val);

        HashMap<Integer, Node> newNodeMap = new HashMap<>();
        Node newNode = new Node(node.val);
        newNodeMap.put(node.val, newNode);

        // WFS遍历过程中，如何新建并遍历newNode呢？
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();

                // 从复制的新节点中，用值找到节点
                Node copy = newNodeMap.get(poll.val);
                if(copy == null) {
                    copy = new Node(poll.val);
                    newNodeMap.put(copy.val, copy);
                }

                // 复制邻居节点
                List<Node> copyNeighbors = new ArrayList<>();
                for (Node neighbor : poll.neighbors) {
                    Node copyNeighbor = newNodeMap.get(neighbor.val);
                    if(copyNeighbor == null) {
                        copyNeighbor = new Node(neighbor.val);
                    }
                    copyNeighbors.add(copyNeighbor);

                    if(!set.contains(neighbor.val)) {
                        set.add(neighbor.val);
                        queue.add(neighbor);
                    }
                }
                copy.neighbors = copyNeighbors;
            }
        }
        return newNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
