package com.boredream.sword2offer;

public class Test14SortArray1to2 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
     *
     * @param arr 输入的数组
     */
    public static void reorderOddEven(int[] arr) {
        if(arr == null || arr.length < 2) return;
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            if(arr[start]%2==0 && arr[end]%2==1) {
                // start偶end奇，交换~
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start ++;
                end --;
            } else if(arr[start] % 2 == 1) {
                // start奇，后移一位
                start ++;
            } else {
                // end偶数，前移一位
                end --;
            }
        }
    }

    /**
     * 输出数组的信息
     *
     * @param arr 待输出数组
     */
    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderOddEven(array);
        printArray(array);
    }
}