package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunyang on 2017/7/24.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) result.add("FizzBuzz");
            else if(i % 3 == 0) result.add("Fizz");
            else if(i % 5 == 0) result.add("Buzz");
            else result.add(String.valueOf(i));
        }
        return result;
    }

}
