package com.boredream.leetcode.lean;

import java.io.File;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws Exception {
        int sum = 0;
        for (File file : Objects.requireNonNull(new File("/Users/chunyangli/Documents/GitHub/JavaCodeProject/src/com/boredream/leetcode/lean").listFiles())) {
            if(file.getName().endsWith(".java") && !file.getName().equals("Main.java")) {
                String className = "com.boredream.leetcode.lean." + file.getName().replace(".java", "");
                Class<?> clazz = Class.forName(className);
                int methodCount = clazz.getDeclaredMethods().length - 1;// main
                System.out.println(file.getName() + " = " + methodCount);
                sum += methodCount;
            }
        }
        System.out.println("-------------------");
        System.out.println("sum = " + sum);

        long num = (long) Float.MIN_VALUE;
        System.out.println(num);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MIN_VALUE);

        System.out.println(Math.pow(3.4, 38));


    }

}
