package com.boredream.AlgBase;

/**
 * 二分查找法，必须是有序集合中查找
 */
public class binarySearch {

    public static void main(StringAlg[] args) {
        System.out.println(binarySearch(new int[]{1,3,5,7,2,2,4,6,8,0}, 7));
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(array[mid] < key) {
                low = mid + 1;
            } else if(array[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
