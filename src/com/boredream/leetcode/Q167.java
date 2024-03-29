package com.boredream.leetcode;

import java.util.Arrays;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * todo 结合二分法会不会更快？
 */
public class Q167 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1 ,0}, -1)));
    }

    static int[] twoSum(int[] numbers, int target) {
        // 思路：正常从左到右，先确定第一个数后，第二个数需要挨个向后遍历，如果找不到则第一个数+1，会 On2 不符合，且未利用升序
        // 应该双指针，从前后一起找，但是什么时候该左指针，什么时候右指针呢？应该是数字不足时左边动，过大时右边动
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            if (numbers[left] + numbers[right] < target) {
                left ++;
            } else if(numbers[left] + numbers[right] > target) {
                right --;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }

}
