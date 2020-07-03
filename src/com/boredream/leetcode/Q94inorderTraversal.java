package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94inorderTraversal {
    public static void main(String[] args) {
        TreeNode test = TreeNode.test();
        System.out.println(inorderTraversal(test));
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 队列，FIFO
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while(node != null) {
                // 一路left下去
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()) {
                // 挨个回头取
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
