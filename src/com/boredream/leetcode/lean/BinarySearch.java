package com.boredream.leetcode.lean;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/binary-search
 */
public class BinarySearch {


    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        System.out.println(search.smallestDistancePair(new int[]{3, 1, 3, 4, 2}, 1));
    }

    //////////////////////// while l <= r //////////////////////////

    // 找到索引
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 根号int
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid < x / mid) {
                l = mid + 1;
            } else if (mid > x / mid) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return r;
    }

    // 猜数字
    public int target;

    public int guess(int num) {
        if (num > target) return 1;
        else if (num < target) return -1;
        return 0;
    }

    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int guess = guess(mid);
            if (guess == 1) {
                r = mid - 1;
            } else if (guess == -1) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return r;
    }

    // 旋转数组里搜
    public int searchRotate(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;

            if (nums[l] < nums[r]) {
                // 正常情况
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                // 有翻转情况
                if (nums[mid] >= nums[l]) {
                    // 翻转在右
                    if (nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        // 左右都可能有更小的目标值，以最右端为基准继续二分
                        if (nums[r] < target) {
                            r = mid - 1;
                        } else {
                            l = mid + 1;
                        }
                    }
                } else {
                    // 翻转在左
                    if (nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        if (nums[r] < target) {
                            r = mid - 1;
                        } else {
                            l = mid + 1;
                        }
                    }
                }
            }
        }
        return -1;
        // TODO: 2020/8/19 简化
    }

    //////////////////////// while l < r //////////////////////////

    // 找到第一个错误版本，>=它的都会错误
    public int firstBadVersion;

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                // 非错误版本
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 找到任意峰顶位置，数字相邻不等
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
        // TODO: 2020/8/19 不一定非要 l r mid target 直接比较
    }

    // 旋转数组里找最小的
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    //////////////////////// while l + 1 < r //////////////////////////

    // 搜索目标值的开始结束位置
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                // 开始两边找
                int l1 = l;
                int r1 = mid;
                while (l + 1 < mid) {
                    int mid1 = l1 + (r1 - l1) / 2;
                    if (nums[mid1] < nums[r1]) {
                        l1 = mid;
                    } else {
                        r1 = mid;
                    }
                }
            }
        }
        return ret;
        // TODO: 2020/8/19 可以直接控制 l<r 条件，保证找到第一个和最后一个。无需两边扩散
    }

    // 与x最接近的k个数字
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new LinkedList<>();
        int l = 0;
        int r = arr.length - 1 - k;
        // 二分+滑动窗口
        while (l <= r) {
            int min = l + (r - l) >> 1;
            int max = min + k;
            if (arr[min] > x) {
                r = min - 1;
            } else if (arr[max] < x) {
                l = min + 1;
            } else {
                // x在min~max之间，根据差值二分调整中间差值

            }
        }
        return list;
        // TODO: 2020/8/20 直接二分查找到index，然后从index-k~index+k，双指针缩到k范围为止
    }

    public int findPeakElement2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // 上升
                l = mid + 1;
            } else {
                // 下降
                r = mid;
            }
        }
        return l;
    }


    // 三种二分写法的比较 https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/935/

    // Template #1 (left <= right):
    //
    // Most basic and elementary form of Binary Search
    // Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
    // No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found
    //
    // 最基础写法。适用于无需和邻居比较时。

    // Template #2 (left < right):
    //
    // An advanced way to implement Binary Search.
    // Search Condition needs to access element's immediate right neighbor
    // Use element's right neighbor to determine if condition is met and decide whether to go left or right
    // Gurantees Search Space is at least 2 in size at each step
    // Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.
    //
    // 适用于需要和右边邻居比较时，如findPeak算法。循环结束后，还剩下一个待选项（l=r) 判断是否可用。

    // Template #3 (left + 1 < right):
    //
    // An alternative way to implement Binary Search
    // Search Condition needs to access element's immediate left and right neighbors
    // Use element's neighbors to determine if condition is met and decide whether to go left or right
    // Gurantees Search Space is at least 3 in size at each step
    // Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the condition.
    //
    // 适用于需要和左右邻居比较时。循环结束后，有俩待选项(l+1=r) 判断是否可用。

    // n方
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double sum = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                // TODO: 2020/8/20 奇数多x一次，但是x已经不停的平方自己了，所以需要个新数字记录
                sum = sum * x;
            }
            x = x * x;
            n = n / 2;
        }
        return sum;
    }

    // 是否是平方数
    public boolean isPerfectSquare(int num) {
        // 二分
        long low = 1;
        long high = num;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // 比tar大的最小字母。letters有序。可循环 a > z
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[0] > target || letters[letters.length - 1] < target) return letters[0];
        int l = 0;
        int r = letters.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return letters[l];
    }

    // 旋转数组里找最小的。相邻数字可能重复。
    public int findMin2(int[] nums) {
        return findMin2(nums, 0, nums.length - 1);
    }

    public int findMin2(int[] nums, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                // 右边有旋转
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                // 左边旋转or正常
                r = mid;
            } else if (nums[mid] > nums[l]) {
                // l < mid = r
                r = mid;
            } else {
//                // l = mid = r
//                // 两边都可能，递归
//                return Math.min(findMin2(nums, l, mid), findMin2(nums, mid, r));
                // TODO: 2020/8/20 简单点
                l++;
                r--;
            }
        }
        return nums[l];
    }

    // 找重复数字。o1空间。数组只读。只有一个重复数字>=2次。数字范围1~n
    public int findDuplicate(int[] nums) {
        // 数字作为索引跳。重复数字会重复
        int fast = nums[0];
        int slow = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (nums[fast] != nums[slow]);
        // TODO: 2020/8/21 这样只代表又换。重复数字应该是进入环的开始点
//        return nums[slow];

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // 找俩有序数组的中间数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;

        // 只有一边有数据，直接取其中位数
        int[] nums = null;
        if (nums1.length == 0) {
            nums = nums2;
        } else if (nums2.length == 0) {
            nums = nums1;
        }
        if (nums != null) {
            int mid = nums.length / 2;
            if (nums.length % 2 == 1) {
                return nums[mid];
            } else {
                return 0.5d * (nums[mid] + nums[mid + 1]);
            }
        }

        int l = 0;
        int r = 0;
        if (nums1[nums1.length - 1] < nums2[0]) {
            // nums1 < nums2
            nums = nums2;
            r = nums2.length - nums1.length;
        } else if (nums1[0] > nums2[nums2.length - 1]) {
            // nums1 > nums2

        } else {
            // nums1 | nums2
            // TODO: 2020/8/21 交叉情况过于复杂。
        }

        return 0;
    }

    // 第k小的两数字之差
    public int smallestDistancePair(int[] nums, int k) {
        // sort
        Arrays.sort(nums);
        // k-th
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < nums.length; i++) {
            int distance = nums[i] - nums[i - 1];
            queue.add(distance);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
        // TODO: 2020/8/21 这种是n-1个差值，其实是22组合个差值
    }
}
