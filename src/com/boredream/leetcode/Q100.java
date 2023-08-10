package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 *
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */
public class Q100 {

    public static void main(String[] args) {
        TreeNode node1 = TreeNode.test();
        node1.left.right.val = 22;

        TreeNode node2 = TreeNode.test();
        System.out.println(isSameTree(node1, node2));
    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null) return false;
        if(q == null) return false;
        // 思路：也是必须要遍历全部。可以队列进行WFS，也可以递归进行DFS
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
