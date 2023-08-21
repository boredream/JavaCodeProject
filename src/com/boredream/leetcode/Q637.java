package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class Q637 {

    public static void main(String[] args) {
        System.out.println(averageOfLevels(TreeNode.test()));
    }

    static List<Double> averageOfLevels(TreeNode root) {
        // 思路：WFS
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            double total = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                total += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(total / size);
        }
        return result;
    }

}
