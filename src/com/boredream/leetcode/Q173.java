package com.boredream.leetcode;


import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // 返回 3
 * bSTIterator.next();    // 返回 7
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 9
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 15
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 20
 * bSTIterator.hasNext(); // 返回 False
 * <p>
 * 提示：
 * 树中节点的数目在范围 [1, 105] 内
 * 0 <= Node.val <= 106
 * 最多调用 105 次 hasNext 和 next 操作
 * <p>
 * <p>
 * 进阶：
 * 你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高度。
 */
public class Q173 {

    static class BSTIterator {

        // 思路：中序遍历，左中右
        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            // 基本功，迭代中序遍历
            stack.add(root);
        }

        public int next() {
            if (stack.isEmpty()) {
                return -1;
            }

            // 先尝试一路递归到最左
            while (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                if (node.left != null) {
                    stack.push(node.left);
                    // 断掉链接，防止下次继续循环
                    // TODO: chunyang 2023/8/18 有待优化
                    node.left = null;
                } else {
                    break;
                }
            }

            TreeNode node = stack.pop();
            // pop 出来，返回值。假设有右指针，入栈
            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.generateByArray(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator bSTIterator = new BSTIterator(node);
        System.out.println();
        System.out.println(bSTIterator.next()); // 返回 3
        System.out.println(bSTIterator.next()); // 返回 7
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next()); // 返回 9
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next()); // 返回 15
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next()); // 返回 20
        System.out.println(bSTIterator.hasNext()); // 返回 False
    }

}
