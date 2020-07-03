package com.boredream.algorithms.base;

public class Search {

    public static void main(String[] args) {
        binarySearchTree();
    }

    public static int search(int[] nums, int target) {
        // 普通查找，遍历比较
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        // 二分查找，是针对有序数组的一种查找方法
        int start = 0;
        int end = nums.length;
        int mid = nums.length / 2;
        while (start <= end) {
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                // 目标应该在mid右边
                start = mid + 1;
            } else {
                // 目标在mid左边
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }

    public static void binarySearchTree() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(2, "aa");
        tree.put(1, "a");
        tree.put(4, "aaaa");
        tree.put(3, "aaa");
        tree.put(5, "aaaaa");

        System.out.println(tree.get(4));
    }

    public static class BinarySearchTree<Key extends Comparable<Key>, Value> {

        public Node root;

        public class Node {
            public Key key;
            public Value value;
            public Node left;
            public Node right;
            public int subCount;

            public Node(Key key, Value value, int subCount) {
                this.key = key;
                this.value = value;
                this.subCount = subCount;
            }
        }

        public int size() {
            return size(root);
        }

        private int size(Node root) {
            if (root == null) return 0;
            return root.subCount;
        }

        // 查找
        public Value get(Key key) {
            // 用递归
            return get(root, key);
        }

        private Value get(Node node, Key key) {
            if (node == null) return null;
            int compare = key.compareTo(node.key);
            if (compare < 0) return get(node.left, key); // < 0 代表目标key比当前node的key小，所以继续去左节点找
            else if (compare > 0) return get(node.right, key); // > 0 代表目标key比当前node的key大，继续去右节点找
            else return node.value; // else == 0，代表key相等，命中，返回value
        }

        // 插入
        public void put(Key key, Value value) {
            // 用递归，类似于查找
            root = put(root, key, value);
        }

        private Node put(Node node, Key key, Value value) {
            if (node == null) node = new Node(key, value, 1); // 目标节点=null，为空，代表是目的位置，新建插入
            int compare = key.compareTo(node.key);
            if (compare < 0) node.left = put(node.left, key, value); // < 0 代表目标key比当前node的key小，所以继续用左节点递归
            else if (compare > 0) node.right = put(node.right, key, value); // < 0 代表目标key比当前node的key小，所以继续用右节点递归
            else node.value = value; // else == 0, key相等，覆盖value
            // 注意更新数量，左右子节点的加上自己1
            node.subCount = size(node.left) + size(node.right) + 1;
            return node;
        }

    }

}
