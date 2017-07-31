package com.boredream.leetcode;

import com.boredream.leetcode.entity.TreeNode;

/**
 * Created by lichunyang on 2017/7/31.
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        int maxDepth = maxDepth(node);
        System.out.println(maxDepth);
    }

    public static int deep = 0;

    /**
     * 计算二叉树最深的那个层级
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        calculateDepth(0, root);
        return deep;
    }

    public static void calculateDepth(int curDeep, TreeNode node) {
        if(node == null) return;
        deep = Math.max(deep, curDeep + 1);
        calculateDepth(curDeep + 1, node.left);
        calculateDepth(curDeep + 1, node.right);
    }

    /**
     * 总结：
     * 二叉树遍历大概会了，不过这题里的depth怎么一层一层传递下去有点晕
     * 所以用了个成员变量，但感觉不够好
     *
     * 看了下其他人算法，觉得自己主要还是带返回值的方法递归用不好，有一种一行代码就搞定的~
     *
     * 还看到一个DFS和BFS分别介绍的答案，但是下面好像对DFS的用法有异议？
     * 主要是用Stack栈 + while循环替代了递归逻辑实现遍历，这个可以参考
     * 尤其他的这个BSF算法，是用队列保存每一层所有的节点，然后一层层的遍历下去~ 很有参考价值
     * 我这种遍历额，不知道是D还是B？
     *
     */

}
