package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Q103 {

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(TreeNode.test()));
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 迭代版本，一层一层来
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean oddLevel = true;
        while(!queue.isEmpty()) {
            // 一层~ 所以一次性for循环完
            LinkedList<Integer> level = new LinkedList<>();
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                if(oddLevel) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(level);
            oddLevel = !oddLevel;
        }
        return list;
    }
}
