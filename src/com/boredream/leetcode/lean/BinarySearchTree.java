package com.boredream.leetcode.lean;

import com.boredream.entity.DataFactory;
import com.boredream.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

/**
 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        System.out.println(new BinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    // BST迭代器。操作都要求o1
    static class BSTIterator {

        private LinkedList<Integer> list;

        public BSTIterator(TreeNode root) {
            if (root == null) return;
            // 中序遍历基本功
            list = new LinkedList<>();
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
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.pop();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return list != null;
        }
    }

    // 插入
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST(root.right, val);
            }
        }
        return root;
        // TODO: 2020/8/21 简化写法
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            root.left = insertIntoBST2(root.left, val);
        } else {
            root.right = insertIntoBST2(root.right, val);
        }
        return root;
        // TODO: 2020/8/21 简化写法
    }

    // 删除节点
    public TreeNode deleteNode(TreeNode root, int key) {
        // 先找
        TreeNode parent = root;
        TreeNode node = root;
        while (node != null && node.val != key) {
            parent = node;
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        // 找不到删除目标
        if (node == null) return root;

        if (node.left == null && node.right == null) {
            // 无child，直接删除
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (node.left == null || node.right == null) {
            // 单个child，替换即可
            if (parent.left == node) {
                parent.left = node.left != null ? node.left : node.right;
            } else {
                parent.right = node.left != null ? node.left : node.right;
            }
        } else {
            // 俩都有值，找到中序的下一个数字，交换后删除
            TreeNode oldLeft = node.left;
            TreeNode oldRight = node.right;

            TreeNode nextParent = node.right;
            TreeNode next = node.right;
            while (next.left != null) {
                nextParent = next;
                next = next.left;
            }

            // 被替换的一定没有left
            if (nextParent.left == null) {

            }
            nextParent.left = nextParent.left.right;

            TreeNode nextLeft = next.left;
            TreeNode nextRight = next.right;

            next.left = oldLeft;
            next.right = oldRight;

            if (parent.left == node) {
                parent.left = next;
            } else {
                parent.right = next;
            }

        }
        // TODO: 2020/8/21 思路正确，写法待优化。 交换的时候只swap值即可，无需完全替换引用。
        return null;
    }

    // 方便找kth的数据结构
    static class KthNode {
        public int val;
        public int cnt;
        public KthNode left;
        public KthNode right;

        public KthNode(int val) {
            this.val = val;
            this.cnt = 1;
        }
    }

    static class KthLargest {

        KthNode root;
        int k;
        int kth;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.kth = Integer.MIN_VALUE;
            if (nums == null || nums.length == 0) return;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            root = addNode(root, val);
            if (val > kth) {
                KthNode node = root;
                int kk = k;
                while (node != null) {
                    int rightK = node.right != null ? node.right.cnt : 0;
                    if (rightK + 1 == kk) {
                        kth = node.val;
                        break;
                    }
                    if (rightK < kk) {
                        kk = kk - rightK - 1;
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                }
            }
            return kth;
        }

        private KthNode addNode(KthNode node, int val) {
            if (node == null) return new KthNode(val);
            node.cnt++;
            if (node.val < val) {
                node.right = addNode(node.right, val);
            } else {
                node.left = addNode(node.left, val);
            }
            return node;
        }
    }

    // 最近公共祖先
    private TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return 值的意义是，返回包含p或q的那个结点，无论是自己还是任意一个child
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            // 左右子节点都包含，那当前结点就是公共祖先
            return root;
        }
        if (left == null && right == null) {
            // 俩子节点都不包含目标
            return null;
        }
        // 左右结点中有一个包含，返回包含的那个
        return left == null ? right : left;
        // TODO: 2020/8/25 return值的意义需要技巧，且这是普通二叉树的方法，BST有更效率的方法
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            TreeNode min, max;
            if (p.val > q.val) {
                min = q;
                max = p;
            } else {
                min = p;
                max = q;
            }
            if (root.val > max.val) {
                node = node.left;
            } else if (root.val < min.val) {
                node = node.right;
            } else {
                // 不可能再进一步去node.left or node.right里取找了
                return node;
            }
        }
        return null;
    }

    // 是否存在数值差<=t 且索引差<=k 的值
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // floor = 比x小的最大数
            Integer floor = set.floor(nums[i]);
            // ceiling = 比x大的最小数
            Integer ceil = set.ceiling(nums[i]);
            // the tricky part I modified to easily understood way.
            if ((floor != null && nums[i] - floor <= t) ||
                    (ceil != null && ceil - nums[i] <= t))
                return true;

            set.add(nums[i]);

            if (i >= k)
                // TODO: 2020/9/2 精华~ 如果i>=k还没有return true，代表i-k之前的都不满足，及时后面有满足的，也超过k距离了
                set.remove(nums[i - k]);

        }
        return false;
    }

    // 是否是平衡树（所有叶节点高度差<=1）
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        // 层遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        Integer minHeight = null;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null) queue.add(poll.left);
                if(poll.right != null) queue.add(poll.right);
            }

            level ++;
            int levelMax = (int) Math.pow(2, level - 1);
            if(queue.size() < levelMax) {
                // 不满一层
                if (minHeight == null) {
                    minHeight = level;
                } else {
                    if (level - minHeight > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
        // TODO: 2020/9/2 题目理解错误，应该是任意结点的左右子节点的高度差都不能超过1
    }

    // 有序数组转平衡二叉树
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return sortedArrayToBST( nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST( nums, start, mid - 1);
        root.right = sortedArrayToBST( nums, mid + 1, end);
        return root;
    }

}
