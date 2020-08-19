package com.boredream.leetcode.lean;

/**
 * https://leetcode.com/explore/learn/card/binary-search
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = {3,1};
        BinarySearch search = new BinarySearch();
        for (int i = 1; i < 9; i++) {
        }
        System.out.println(search.searchRotate(nums, 1));
    }

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
            if(nums[mid] == target) return mid;

            if(nums[l] < nums[r]) {
                // 正常情况
                if(nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                // 有翻转情况
                if(nums[mid] >= nums[l]) {
                    // 翻转在右
                    if(nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        // 左右都可能有更小的目标值，以最右端为基准继续二分
                        if(nums[r] < target) {
                            r = mid - 1;
                        } else {
                            l = mid + 1;
                        }
                    }
                } else {
                    // 翻转在左
                    if(nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        if(nums[r] < target) {
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
}
