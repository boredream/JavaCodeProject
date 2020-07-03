package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的深度
 */
public class TreeDepth {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.test();
        tree.right.left.left = new TreeNode(2);
        System.out.println(TreeDepth2(tree));
    }

    static int TreeDepth1(TreeNode root) {
        // 思路1：因为是找多个路径里最长的那个，所以使用BFS广度优先搜索
        if (root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 传统BFS不用for循环，直接里面代码。但是无法区分是不是新的一层又开始了，所以for循环每次一层
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            count++;
        }
        return count;
    }

    static int TreeDepth2(TreeNode root) {
        // 思路2：BFS的递归写法，貌似更简单，网上看到的。
        if(root == null) return 0;
        // 返回左、右子节点里更大的那个，然后在此基础上+1。没有子节点时，下一层深度就是0；
        return Math.max(TreeDepth2(root.left), TreeDepth2(root.right)) + 1;
    }

}
