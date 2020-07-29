package com.boredream.leetcode.lean;

import com.boredream.entity.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/
 */
public class BinaryTree {

    public static void main(String[] args) {
        //       4
        //     /   \
        //    2     6
        //  / \     / \
        // 1   3   5   7
        TreeNode node = TreeNode.testSort();

        List<Integer> preList = new BinaryTree().preorderTraversal(node);
        List<Integer> inList = new BinaryTree().inorderTraversal(node);
        int[] preorder = new int[preList.size()];
        for (int i = 0; i < preList.size(); i++) {
            preorder[i] = preList.get(i);
        }
        int[] inorder = new int[inList.size()];
        for (int i = 0; i < inList.size(); i++) {
            inorder[i] = inList.get(i);
        }

        System.out.println(preList);
        System.out.println(inList);

        TreeNode treeNode = new BinaryTree().buildTree2(preorder, inorder);
        System.out.println(node);
        System.out.println(treeNode);
    }

    // 基本功，前中后序的递归or迭代写法

    // 前序遍历，中左右
    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }

            TreeNode pop = stack.pop();
            node = pop.right;
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        // 递归
        List<Integer> list = new LinkedList<>();
        preorderTraversal(list, root);
        return list;
    }

    public void preorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preorderTraversal(list, root.left);
        preorderTraversal(list, root.right);
    }

    // 中序遍历，左中右
    public List<Integer> inorderTraversal(TreeNode root) {
        // 迭代
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            TreeNode pop = stack.pop();
            list.add(pop.val);
            node = pop.right;
        }

        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        // 递归
        List<Integer> list = new LinkedList<>();
        inorderTraversal(list, root);
        return list;
    }

    public void inorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inorderTraversal(list, root.left);
        list.add(root.val);
        inorderTraversal(list, root.right);
    }

    // 后续遍历，左右中
    public List<Integer> postorderTraversal(TreeNode root) {
        // 迭代
        // 和前序反过来，中左右 -> 左右中，一样写法。左右反过来，且插入列表时从头反过来插入
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.addFirst(node.val);
                stack.push(node);
                node = node.right;
            }
            TreeNode pop = stack.pop();
            node = pop.left;
        }
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        // 递归
        List<Integer> list = new LinkedList<>();
        postorderTraversal(list, root);
        return list;
    }

    public void postorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        postorderTraversal(list, root.left);
        postorderTraversal(list, root.right);
        list.add(root.val);
    }

    // TODO: 2020/7/28 迭代写法还有其他

    // 层遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 迭代
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                levelList.add(pop.val);
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
            list.add(levelList);
        }
        return list;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        // 递归
        List<List<Integer>> list = new ArrayList<>();
        levelOrder2(list, root, 0);
        return list;
    }

    public void levelOrder2(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        List<Integer> levelList;
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        levelList = list.get(level);
        levelList.add(root.val);

        levelOrder2(list, root.left, level + 1);
        levelOrder2(list, root.right, level + 1);
    }


    // 递归

    // "Top-down" Solution
    // 1. return specific value for null node
    // 2. update the answer if needed                      // answer <-- params
    // 3. left_ans = top_down(root.left, left_params)      // left_params <-- root.val, params
    // 4. right_ans = top_down(root.right, right_params)   // right_params <-- root.val, params

    // "Bottom-up" Solution
    // 1. return specific value for null node
    // 2. left_ans = bottom_up(root.left)          // call function recursively for left child
    // 3. right_ans = bottom_up(root.right)        // call function recursively for right child
    // 4. return answers                           // answer <-- left_ans, right_ans, root.val

    // bottom-up 有点类似 dp，如果对每个子树能利用child得出parent，则适用。

    // 从上到下递归，带着每层更新的参数下去，依次寻找更新答案
    private int answer;        // don't forget to initialize answer before call maximum_depth

    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }

    // 从下到上递归，利用下面的答案反过来一层层更新上面的答案
    public int maximum_depth(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = maximum_depth(root.left);
        int maxRight = maximum_depth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

    // 判断是否是左右对称树
    public boolean isSymmetric(TreeNode root) {
        // left.left = right.right + left.right = right.left 则对称。
        return isReverse(root.left, root.right);
        // TODO: 2020/7/29 还有迭代算法
    }

    public boolean isReverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        // 俩值相等，且各自子树值对称
        return left.val == right.val && isReverse(left.left, right.right) && isReverse(left.right, right.left);
    }

    // 判断是否有root到leaf的一个分支
    public boolean hasPathSum(TreeNode root, int sum) {
        // b2l，子树是叶子时，对比剩余数字sum和root当前数字。然后回推，parent的俩分支任意一个满足即可
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    // 利用不同遍历结果，构造二叉树

    // 中序、后序，构造二叉树。无重复数字
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 左中右 + 左右中
        // 为了快速定位数字位置，使用hash map
        HashMap<Integer, Integer> numPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numPosMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                numPosMap);
    }

    public TreeNode buildTree(int[] inorder, int is, int ie,
                              int[] postorder, int ps, int pe,
                              HashMap<Integer, Integer> numPosMap) {
        if (is > ie || ps > pe) return null;
        // 后序的末尾是root，然后该val将中序左右两分对应root俩子树。
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        // left使用inorder的rootVal左分数字 + postorder的前inorder左分长度的数字
        Integer rootPosition = numPosMap.get(rootVal);
        int leftIs = is;
        int leftIe = rootPosition - 1;
        int leftPs = ps;
        int leftPe = ps + (leftIe - leftIs);
        root.left = buildTree(inorder, leftIs, leftIe, postorder, leftPs, leftPe, numPosMap);
        // right对称
        int rightIs = rootPosition + 1;
        int rightIe = ie;
        int rightPs = leftPe + 1;
        int rightPe = pe - 1;
        root.right = buildTree(inorder, rightIs, rightIe, postorder, rightPs, rightPe, numPosMap);
        return root;
    }

    // 前序、中序，构造二叉树。无重复数字
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        // 同中后序逻辑
        HashMap<Integer, Integer> numPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numPosMap.put(inorder[i], i);
        }
        return buildTree2(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1,
                numPosMap);
    }

    public TreeNode buildTree2(int[] preorder, int ps, int pe,
                               int[] inorder, int is, int ie,
                               HashMap<Integer, Integer> numPosMap) {
        if (ps > pe || is > ie) return null;
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);
        Integer rootPosition = numPosMap.get(rootVal);
        int leftIs = is;
        int leftIe = rootPosition - 1;
        int leftPs = ps + 1;
        int leftPe = leftPs + (leftIe - leftIs);
        root.left = buildTree2(preorder, leftPs, leftPe, inorder, leftIs, leftIe, numPosMap);
        int rightIs = rootPosition + 1;
        int rightIe = ie;
        int rightPs = leftPe + 1;
        int rightPe = pe;
        root.right = buildTree2(preorder, rightPs, rightPe, inorder, rightIs, rightIe, numPosMap);
        return root;
    }

}
