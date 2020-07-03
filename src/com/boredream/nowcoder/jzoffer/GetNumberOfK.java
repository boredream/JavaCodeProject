package com.boredream.nowcoder.jzoffer;

/**
 * 有序数组中某数字出现次数
 */
public class GetNumberOfK {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3};
        System.out.println(GetNumberOfK2(array, 3));
    }

    static int GetNumberOfK1(int[] array, int k) {
        // 思路1：注意是有序数组。所以二分查找。先找到目标k，然后向前向后挨个遍历++
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (array[mid] < k) {
                // 目标大于中间数，继续再右侧找
                lo = mid + 1;
            } else if (array[mid] > k) {
                // 目标小于中间数，继续再左侧找
                hi = mid - 1;
            } else {
                // 相等
                break;
                // 但是这里break后继续向前后++，当连续数字过大时，效率还是慢
            }
        }
        return -1;
    }

    static int GetNumberOfK2(int[] array, int k) {
        // 思路1：注意是有序数组。所以二分查找。找到k第一次出现和最后一次出现位置，然后相减得到数量，依然也是二分去找。
        if (array == null || array.length == 0) return 0;
        int firstK = findFirstK(array, k);
        int lastK = findLastK(array, k);
        if (firstK == -1 || lastK == -1) return 0;
        return lastK - firstK + 1;
    }

    static int findFirstK(int[] array, int k) {
        int lo = 0;
        int hi = array.length - 1;
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            if (array[mid] < k) {
                // 目标大于中间数，继续再右侧找
                lo = mid + 1;
            } else if (array[mid] > k) {
                // 目标小于中间数，继续再左侧找
                hi = mid - 1;
            } else if (mid - 1 >= 0 && array[mid - 1] == k) {
                // 核心在于这里的条件，如果上一个数字存在且也等于k，则继续向左侧二分查找
                hi = mid - 1;
            } else {
                // 相等
                return mid;
            }
            mid = (lo + hi) / 2;
        }
        return -1;
    }

    static int findLastK(int[] array, int k) {
        int lo = 0;
        int hi = array.length - 1;
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            if (array[mid] < k) {
                // 目标大于中间数，继续再右侧找
                lo = mid + 1;
            } else if (array[mid] > k) {
                // 目标小于中间数，继续再左侧找
                hi = mid - 1;
            } else if (mid + 1 < array.length && array[mid + 1] == k) {
                // 核心在于这里的条件，如果下一个数字存在且也等于k，则继续向右侧二分查找
                lo = mid + 1;
            } else {
                // 相等
                return mid;
            }
            mid = (lo + hi) / 2;
        }
        return -1;
    }
}
