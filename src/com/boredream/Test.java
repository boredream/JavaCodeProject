package com.boredream;

public class Test {

    public static void main(String[] args) {
        System.out.println(method());
    }

    private static int method() {
        try {
            System.out.println("tryyyyyy");
            return 1;
        } finally {
            System.out.println("finallyyyyyyyyy");
        }
    }
}
