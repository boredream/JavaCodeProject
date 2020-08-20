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
    }

}
