package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.test();
        System.out.println(Print(tree));
    }

    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // 思路1：依然是BFS，换个写法递归~
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        bfs(pRoot, 1, list);
        return list;
    }

    static void bfs(TreeNode node, int depth, ArrayList<ArrayList<Integer>> list) {
        if (node == null) return;

        if (depth > list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(depth - 1).add(node.val);
        bfs(node.left, depth + 1, list);
        bfs(node.right, depth + 1, list);
    }

}
