package com.boredream.leetcode;

import com.boredream.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个至少有俩节点的二叉树，值都是非负的，寻找任意两个节点之间最小的差值
 */
public class MinimumAbsoluteDifferenceInBST {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(5);
        node.right = new TreeNode(3);
        System.out.println(getMinimumDifference(node));
    }

    /**
     * 思路：遍历所有节点，组合算法取俩节点获取差值，取最小的一个
     */
    static int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        addAll(values, root);
        combination(new ArrayList<>(), values, 2);
        return min;
    }

    public static int min = Integer.MAX_VALUE;

    public static void addAll(List<Integer> values, TreeNode root) {
        if(root == null) return;
        values.add(root.val);
        addAll(values, root.left);
        addAll(values, root.right);
    }

    public static void combination(List<Integer> temp, List<Integer> values, int n) {
        if (n == 0) {
            int diff = Math.abs(temp.get(0) - temp.get(1));
            min = Math.min(diff, min);
        } else {
            for (int i = 0; i < values.size() - (n - 1); i++) {
                List<Integer> nList = new ArrayList<>();
                nList.addAll(temp);
                nList.add(values.get(i));
                // 建立从i开始的子数组
                List<Integer> list = new ArrayList<>();
                for (int j = 0; n > 1 && j < values.size() - i - 1; j++) {
                    list.add(values.get(i+j+1));
                }
                combination(nList, list, n - 1);
            }
        }
    }

    /**
     * 忒复杂~ 遍历一遍，然后组合一遍~
     * 看了下网上的答案，有一种是试用TreeSet保存数据，这种Set提供floor和ceiling俩方法直接提供最大、最小值
     *
     */


}
