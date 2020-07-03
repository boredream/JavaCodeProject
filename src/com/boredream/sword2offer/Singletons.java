package com.boredream.sword2offer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现 Singleton 模式——七种实现方式
 */
public class Singletons {

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            for (int i12 = 0; i12 < 100000000; i12++) {
                method();
            }
        }).start();
        new Thread(() -> {
            for (int i1 = 0; i1 < 100000000; i1++) {
                method();
            }
        }).start();
        new Thread(() -> {
            for (int i12 = 0; i12 < 100000000; i12++) {
                method();
            }
        }).start();

        Thread.sleep(2000);

        System.out.println(i);

    }

    private static AtomicInteger i = new AtomicInteger(0);
    private static void method() {
        i.addAndGet(1);
    }


    /**
     * 饿汉
     */
    public static class Singleton1 {
        private static Singleton1 instance = new Singleton1();
        private Singleton1() {}
        public static Singleton1 getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉
     */
    public static class Singleton2 {
        private static Singleton2 instance;
        private Singleton2() {}
        public static Singleton2 getInstance() {
            if(instance == null) instance = new Singleton2();
            return instance;
        }
    }

    /**
     * 懒汉
     * 使用双重校验锁，线程安全
     */
    private static class Singleton3 {
        private volatile static Singleton3 instance = null;
        private Singleton3() {}
        public static Singleton3 getInstance() {
            if (instance == null) {
                synchronized (Singleton3.class) {
                    if (instance == null) {
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }
    }

}
