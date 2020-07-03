package com.boredream.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class SortNums {

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        System.out.println(PrintMinNumber(nums));
    }

    static String PrintMinNumber(int [] numbers) {
        StringBuilder result = new StringBuilder();
        if(numbers.length > 0) {
            ArrayList<String> list = new ArrayList<>();
            for (int number : numbers) {
                list.add(number + "");
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            for (String s : list) {
                result.append(s);
            }
        }
        return result.toString();
    }

}
