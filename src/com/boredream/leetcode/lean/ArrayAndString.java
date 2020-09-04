package com.boredream.leetcode.lean;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/
 */
public class ArrayAndString {

    public static void main(String[] args) {
        System.out.println(new ArrayAndString().reverseWords("   a   b  c d   e  "));
    }

    // 左边和与右边和相等的点
    public int pivotIndex(int[] nums) {
        // 因为有负数，所以直接双指针没用。直接hash map两头分别找
        HashMap<Integer, HashSet<Integer>> sumPos = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            HashSet<Integer> set = sumPos.get(sum);
            if (set == null) set = new HashSet<>();
            set.add(i);
        }
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            HashSet<Integer> set = sumPos.get(sum);
            if (set != null && set.contains(i - 2)) return i - 1;
        }
        return -1;
        // TODO: 2020/8/13 思路是对的，但是不需要保存map，左到右保存个sum，然后开始右到左根据sum和变化找到平衡点
    }

    // 左边和与右边和相等的点
    public int pivotIndex2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int rightSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    // 找到某数字是别人的2倍大
    public int dominantIndex(int[] nums) {
        int ret = -1;
        double doub = 0;
        double half = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] > half && nums[i] < doub) {
                // 不满足
                ret = -1;
            } else {
                // 满足，取大的值
                if (ret == -1 || nums[i] > nums[ret]) {
                    ret = i;
                }
            }

            // 更新边界值
            doub = Math.max(doub, 2f * nums[i]);
            half = Math.max(half, 1 / 2f * nums[i]);
        }
        return ret;
        // TODO: 2020/8/13 题目理解错误。是看最大的数字是否是其他的两倍或以上
    }

    // 找到最大的数字是别人的2倍
    public int dominantIndex2(int[] nums) {
        int ret = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1 / 2f * max && nums[i] < 2f * max) {
                // 打破满足条件
                ret = -1;
            } else {
                // 符合条件
                if (nums[i] > max) {
                    // 更大的数字才更新
                    ret = i;
                }
            }
            max = Math.max(nums[i], max);
        }
        return ret;
    }

    // +1
    public int[] plusOne(int[] digits) {
        int add = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + add;
            if (i == digits.length - 1) sum++;
            add = sum / 10;
            sum = sum % 10;
            digits[i] = sum;
        }
        if (add == 1) {
            int[] newDig = new int[digits.length + 1];
            for (int i = 0; i < newDig.length; i++) {
                if (i == 0) newDig[i] = 1;
                else newDig[i] = digits[i - 1];
            }
            return newDig;
        }
        return digits;
    }

    // 斜Z型遍历
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            int[] ret = new int[0];
            return ret;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[] ret = new int[rowCount * colCount];
        int row = 0, col = 0;
        for (int i = 0; i < ret.length; i++) {
            ret[i] = matrix[row][col];
            if ((row + col) % 2 == 0) {
                // up
                if (row > 0 && col < colCount - 1) {
                    // /up
                    row--;
                    col++;
                } else if (row == 0 && col < colCount - 1) {
                    // -right
                    col++;
                } else {
                    // |down
                    row++;
                }
            } else {
                // down
                if (row < rowCount - 1 && col > 0) {
                    // /down
                    row++;
                    col--;
                } else if (col == 0 && row < rowCount - 1) {
                    // |down
                    row++;
                } else {
                    // -right
                    col++;
                }
            }
        }
        return ret;
    }

    // 螺旋遍历
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int row = 0, col = 0;
        int[] dir = {1, 0};
        for (int i = 0; i < rowCount * colCount; i++) {
            list.add(matrix[row][col]);
            col += dir[0];
            row += dir[1];
            if (col >= colCount) {
                // 向右超过边界了，开始向下
                col--;
                row++;
                dir[0] = 0;
                dir[1] = 1;
            } else if (row >= rowCount) {
                // 向下越界
                row--;
                col--;
                dir[0] = -1;
                dir[1] = 0;
            } else if (col < 0) {
                // 向左越界
                col++;
                row--;
                dir[0] = 0;
                dir[1] = -1;
            } else if (row < 0) {
                // 向上越界
                row--;
                col++;
                dir[0] = 1;
                dir[1] = 0;
            }
        }
        return list;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int startRow = 0;
        int endRow = rowCount - 1;
        int startCol = 0;
        int endCol = colCount - 1;
        while (list.size() < rowCount * colCount) {
            // l2r
            for (int i = startCol; i <= endCol; i++) {
                list.add(matrix[startRow][i]);
            }
            startRow++;

            // t2b
            for (int i = startRow; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }
            endCol--;

            // r2l
            if (startRow <= endRow) {
                // TODO: 2020/8/13 注意这两个条件，最后一轮循环如果只剩单行/列，可能错位
                for (int i = endCol; i >= startCol; i--) {
                    list.add(matrix[endRow][i]);
                }
            }
            endRow--;

            // b2t
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    list.add(matrix[i][startCol]);
                }
            }
            startCol++;
        }
        return list;
    }

    // 杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows <= 0) return list;
        List<Integer> pre = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < row; col++) {
                if (col == 0 || col == row - 1) {
                    rowList.add(1);
                } else {
                    rowList.add(pre.get(col - 1) + pre.get(col));
                }
            }
            list.add(rowList);
            pre.clear();
            pre.addAll(rowList);
        }
        return list;
    }

    // 二进制加法
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int aIndex = a.length() - i - 1;
            int bIndex = b.length() - i - 1;
            int sum = add;
            if (aIndex >= 0) {
                sum += (a.charAt(aIndex) - '0');
            }
            if (bIndex >= 0) {
                sum += (b.charAt(bIndex) - '0');
            }
            add = sum / 2;
            sb.append(sum % 2 == 0 ? '0' : '1');
        }
        if (add == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    // indexOf
    public int strStr(String haystack, String needle) {
        // TODO: 2020/8/13 暴力不可取。还有KMP算法
        return -1;
    }

    // 最长pre共同字符串
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        for (int index = 0; ; index++) {
            Character c = null;
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    c = null;
                    break;
                }
                if (c == null) {
                    c = strs[i].charAt(index);
                } else if (strs[i].charAt(index) != c) {
                    c = null;
                    break;
                }
            }
            if (c == null) {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 翻转字符串
    public void reverseString(char[] s) {
        // 双指针
        if (s == null || s.length <= 1) return;
        for (int start = 0, end = s.length - 1; start < end; start++, end--) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
        }
    }

    // 凑成一对对，然后求最大的所有min一对之和
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) sum += nums[i];
        return sum;
    }

    // 两数之和。有序数组。
    public int[] twoSum(int[] numbers, int target) {
        // 双指针。可能有负数。
        int[] ret = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                ret[0] = low + 1;
                ret[1] = high + 1;
                break;
            }
            if (sum > target) {
                // 需要缩小，右指针左移
                high--;
            } else {
                // 需要放大
                low++;
            }
        }
        return ret;
        // TODO: 2020/8/14 还可以二分
    }

    // 删除元素，前移。最后返回删除后长度
    public int removeElement(int[] nums, int val) {
        // 双指针。快的一直遍历，慢的记录删除后元素。
        int low = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[low++] = nums[fast];
            }
        }
        return low;
    }

    // 和>=s的最短连续子集长度
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= s) {
                length = Math.min(length, r - l);
                sum -= nums[l++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    // 旋转数组。尽量o1空间
    public void rotate(int[] nums, int k) {
        // 正常逻辑，右移1，循环k次
        if (nums.length == 1) return;
        int move = k % nums.length;
        if (move == 0) return;
        int start = 0;
        int startNum = nums[start];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = (index + (nums.length - move)) % nums.length;
            if (next == start) {
                // 正好是一个循环
                nums[index] = startNum;
                // 前进一位
                index = next + 1;
                start = index;
                startNum = nums[start];
            } else {
                nums[index] = nums[next];
                index = next;
            }
        }
    }

    // 杨辉三角
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;
        for (int i = 1; i < rowIndex; i++) {
            int size = list.size();
            list.add(1);
            for (int j = size - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }

    // 翻转单词
    public String reverseWords(String s) {
        // 整体reverse，每个词reverse
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        boolean enableSpace = true;
        for (char c : s.trim().toCharArray()) {
            if (c == ' ') {
                if (enableSpace) {
                    sb.append(c);
                }
                enableSpace = false;
            } else {
                sb.append(c);
                enableSpace = true;
            }
        }
        sb.reverse();
        String[] split = sb.toString().split(" ");
        sb = new StringBuilder();
        for (String word : split) {
            sb.append(" ").append(new StringBuilder(word).reverse().toString());
        }
        return sb.substring(1);
    }

    // 翻转单词
    public String reverseWords2(String s) {
        // 每个词reverse
        if (s == null || s.length() == 0) return s;
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : split) {
            sb.append(" ").append(new StringBuilder(word).reverse().toString());
        }
        return sb.substring(1);
    }
}
