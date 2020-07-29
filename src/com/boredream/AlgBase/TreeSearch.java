package com.boredream.AlgBase;

import com.boredream.entity.TreeNode;

import java.util.Stack;

/**
 * 二叉树遍历
 * https://www.jianshu.com/p/456af5480cee
 */
public class TreeSearch {


    public static void main(StringAlg[] args) {
        //       8
        //    /    \
        //   6      10
        //  / \     / \
        // 5   7   9  11

        // 前序遍历：根结点 ---> 左子树 ---> 右子树
        // 中序遍历：左子树 ---> 根结点 ---> 右子树
        // 后序遍历：左子树 ---> 右子树 ---> 根结点

        TreeNode test = TreeNode.test();

        // 递归写法
        preRec(test);
        System.out.println();
        midRec(test);
        System.out.println();
        afterRec(test);
        System.out.println();
        System.out.println();

        // 非递归写法
        preNotRec(test);
        System.out.println();
        midNotRec(test);
        System.out.println();
    }

    /**
     * 前序递归版
     */
    private static void preRec(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preRec(root.left);
        preRec(root.right);
    }

    /**
     * 中序递归版
     */
    private static void midRec(TreeNode root) {
        if (root == null) return;
        midRec(root.left);
        System.out.print(root.val + " ");
        midRec(root.right);
    }

    /**
     * 后续递归版
     */
    private static void afterRec(TreeNode root) {
        if (root == null) return;
        afterRec(root.left);
        afterRec(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 前序非递归版
     */
    private static void preNotRec(TreeNode root) {
        if (root == null) return;

        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.val + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 弹出栈顶元素，将游标等于该 节点的右子树
            node = treeNodeStack.pop();
            node = node.right;
        }

        // 相当于一路向左走，没路过一个节点都打印并缓存
        // 直到向左走到底，开始回头向右，所以就用到之前缓存的数据反着一个个弹出，再走右结点。
        // 因为反着弹出所以用Stack先进后出的数据结构
        // 然后每返回一步遍历右结点又要看右结点是否有新的左路径可以走，因此弹出一个就回到大循环继续之前逻辑
    }

    /**
     * 中序非递归版
     */
    private static void midNotRec(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            node = treeNodeStack.pop();
            System.out.print(node.val + " ");
            node = node.right;
        }

        // 和前序遍历顺序逻辑一样，只不过打印数据不是在第一次遇到就打印，而是中序的左-根-右顺序
        // 因此在回退的那步进行打印
    }

    /**
     * 后续非递归版
     */
    private static void afterNotRec(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }

        // 遍历顺序其实都是还一样，但左遍历结束后返回根结点一次，且右结点遍历也会返回一次。之前逻辑就无法判断了
        // 逻辑有点难理解 TODO

    }


}
