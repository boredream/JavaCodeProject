package com.boredream.nowcoder.jzoffer;

import com.boredream.entity.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindTreeSumPath {

    // TODO: 2019/2/1

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6      10
        //  / \     / \
        // 5   7   9  11

        TreeNode node = TreeNode.test();
        node.left.right.right = new TreeNode(6);
        System.out.println(FindPath1(node, 27));
    }

    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        if (root == null) return result;

        // 思路1：dfs，使用非递归，携带一个已有数组+综合去向下递归。
        FindSubPath(root, target, new ArrayList<>(), 0);
        return result;
    }

    private static void FindSubPath(TreeNode root, int target, ArrayList<Integer> existArray, int existSum) {
        if (root == null) return;

        // 累加新节点
        existArray.add(root.val);
        existSum += root.val;

        if (root.left == null && root.right == null && existSum == target) {
            // 如果是最底部叶节点，且相等，记录新增路径
            result.add(new ArrayList<>(existArray));
        }
        System.out.println(root.val);
        FindSubPath(root.left, target, existArray, existSum);
        FindSubPath(root.right, target, existArray, existSum);

        // 注意一旦回头走另一个分支，就删除当前这个
        existArray.remove(existArray.size() - 1);
    }

    private static ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        // 思路2：网上的。跟方法1总体思路一毛一样，更精简一点。
        // 只用自己的方法递归，不用existSum，而是target -= root.val 向下传递target，然后成员变量临时集合和总集合集合
        return null;
    }
}
