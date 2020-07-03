package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class ZprintTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.test();
        for (ArrayList<Integer> arrayList : Print3(tree)) {
            for (Integer integer : arrayList) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        // 思路1：BFS广度优先搜索，一层一层来。用堆/栈+while方式。
        // 然后小变化是左右顺序轮流，用flag区分，List根据flag插入尾部or头部，但插入的效率有点慢
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        ArrayList<Integer> list;
        boolean positive = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (positive) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
            }

            positive = !positive;
            result.add(list);
        }
        return result;
    }

    static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        // 思路2：和1基本一样，但是利用栈+队列，一个FIFO一个FILO交换着来。 FIXME 错误，因为第一轮栈反过来后，下一轮用队列依然是按照栈的反着的顺序。
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        ArrayList<Integer> list;

        Stack<TreeNode> stack = new Stack<>();

        while (!queue.isEmpty() || !stack.isEmpty()) {
            list = new ArrayList<>();

            if(!queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) stack.add(node.left);
                    if (node.right != null) stack.add(node.right);
                }
            } else {
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    list.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }

            result.add(list);
        }
        return result;
    }

    static ArrayList<ArrayList<Integer>> Print3(TreeNode pRoot) {
        // 思路3：基于思路2，用俩栈，来回倒，才能正序逆序正序的来
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(pRoot);

        ArrayList<Integer> list;

        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            list = new ArrayList<>();

            if(!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left != null) stack2.add(node.left);
                    if (node.right != null) stack2.add(node.right);
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if (node.right != null) stack1.add(node.right);
                    if (node.left != null) stack1.add(node.left);
                }
            }

            result.add(list);
        }
        return result;
    }

}
