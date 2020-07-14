package com.boredream.leetcode.lean;

import java.util.HashSet;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays
 */
public class Arrays {

    public static void main(String[] args) {
        int[] nums = {0};
        new Arrays().sortArrayByParity(nums);
        System.out.println(java.util.Arrays.toString(nums));
    }

    // 找到最长的连续非0数字长度
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur = 0;
            } else {
                cur++;
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    // 判断有几个偶数位数的数字
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            // 判断偶数
            // 1: toString.size()
            // 2: 递归 /10
            boolean isEven = false;
            while (num >= 10) {
                num /= 10;
                isEven = !isEven;
            }
            if (isEven) {
                result++;
            }
        }
        return result;
    }

    // 顺序数组，重组成所有数字平方数后的顺序数组
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        // 双指针，谁绝对值大，先取谁，从后往前放置
        int low = 0;
        int high = A.length - 1;
        int index = high;
        for (int i = index; i >= 0; i--) {
            if (Math.abs(A[low]) < Math.abs(A[high])) {
                B[i] = A[high] * A[high];
                high--;
            } else {
                B[i] = A[low] * A[low];
                low++;
            }
        }
        return B;
    }

    // INSERT

    // 遇到0复制一次，同时右边的数字向右移动，原有数组上操作
    public void duplicateZeros(int[] arr) {
        int[] move = new int[arr.length];
        int zeroCount = 0;
        // 第一轮记录所有数字需要右移几次
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            } else {
                move[i] = zeroCount;
            }
        }

        // 第二轮倒序遍历
        for (int i = arr.length - 1; i >= 0; i--) {
            if (move[i] > 0) {
                // 需要右移
                if (i + move[i] <= arr.length - 1) {
                    arr[i + move[i]] = arr[i];
                } else {
                    // 如果右移超过数组长度，数字移除，即不处理即可
                }
                // 移动后，当前数字置为0
                arr[i] = 0;
            } else {
                // 不需要右移，保持不变
            }
        }
    }

    public void duplicateZeros2(int[] arr) {
        // 空间 n 优化到 1 版本
        int zeroCount = 0;
        for (int i : arr) {
            if (i == 0) zeroCount++;
        }

        // 第二轮倒序遍历
        // 0数量清空的时候也可以暂停了
        for (int i = arr.length - 1; zeroCount > 0; i--) {
            if (arr[i] == 0) {
                zeroCount--;
            } else {
                // 非0，向右copy，超出范围的抛弃
                if (i + zeroCount < arr.length) {
                    arr[i + zeroCount] = arr[i];
                }
                arr[i] = 0;
            }
        }
    }

    // 俩排序合并成一个，放在num1，长度够
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 结果在nums1上，只能倒序走，防止有效值覆盖
        // 条件 n > 0，代表nums2还有数字未插入，都插入的话剩下的都是1了可以结束
        int len = m + n;
        m--;
        n--;
        for (int i = len - 1; n >= 0; i--) {
            if (m < 0 || nums1[m] < nums2[n]) {
                nums1[i] = nums2[n--];
            } else {
                nums1[i] = nums1[m--];
            }
        }
    }

    // 删除所有val，其他数字前移，返回剩余数字长度
    public int removeElement(int[] nums, int val) {
        // 记录删除数字，然后后续数字前移删除数量长度
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                length++;
            } else {
                nums[i - length] = nums[i];
            }
        }
        return nums.length - length;
    }

    // 有序数组。删除重复数字，非重复的前移，最后返回非重复长度
    public int removeDuplicates(int[] nums) {
        // 双指针，low指向非重复到达位置，fast指针遍历全部，和low比较
        int low = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[low] != nums[i]) {
                nums[++low] = nums[i];
            }
        }
        return low + 1;
    }

    // 找到是否有一个数字是另一个2倍
    public boolean checkIfExist(int[] arr) {
        // hash
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) return true;
            set.add(i);
        }
        return false;
    }

    // 小大小，不能有连续相等情况
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        // 双指针，遇到下降停止，最后判断是否同一个点
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            boolean leftUp = A[low + 1] > A[low];
            if (leftUp) low++;
            boolean rightUp = A[high - 1] > A[high];
            if (rightUp) high--;
            if (!leftUp && !rightUp) break;
        }
        return low != 0 && high != A.length - 1 && low == high;
        // TODO 俩while可以分开，不用while里判断break，时间复杂度不变
    }

    // 每个数字都替换成右边所有数中最大的，最后一个-1
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int newMax = Math.max(arr[i], max);
            arr[i] = max;
            max = newMax;
        }
        return arr;
    }

    // 左右0移到右侧
    public void moveZeroes(int[] nums) {
        int numberIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[numberIndex++] = nums[i];
            }
        }
        for (int i = numberIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 先偶数后奇数
    public int[] sortArrayByParity(int[] A) {
        // 双指针交换
        int low = 0;
        int high = A.length - 1;
        while (true) {
            while (low < high && A[low] % 2 == 0) low++;
            while (low < high && A[high] % 2 == 1) high--;
            if (low >= high) break;
            int temp = A[low];
            A[low] = A[high];
            A[high] = temp;
        }
        return A;
        // TODO: 2020/7/13 也可以直接冒泡方式，左到右for循环，奇偶交换
    }

    // 排序前后有多少个数字不同
    public int heightChecker(int[] heights) {
        int count = 0;
        return count;
    }

}
