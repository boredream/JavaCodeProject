package com.boredream.leetcode.lean;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/explore/learn/card/n-ary-tree
 */
public class NAryTree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        preorder(list, root);
        return list;
    }

    private void preorder(List<Integer> list, Node root) {
        if(root == null) return;
        list.add(root.val);
        if (root.children == null) return;
        for (Node node : root.children) preorder(list, node);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        postorder(list, root);
        return list;
    }

    private void postorder(List<Integer> list, Node root) {
        if(root == null) return;
        if (root.children == null) return;
        for (Node node : root.children) postorder(list, node);
        list.add(root.val);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                level.add(poll.val);

                if(poll.children == null) continue;
                queue.addAll(poll.children);
            }
            list.add(level);
        }
        return list;
    }

    private int maxDepth;

    public int maxDepth(Node root) {
        maxDepth(root, 0);
        return maxDepth;
    }

    private void maxDepth(Node root, int level) {
        if(root == null) return;
        level ++;
        maxDepth = Math.max(level, maxDepth);
        if(root.children == null) return;
        for (Node node : root.children) {
            maxDepth(node, level);
        }
    }
}
