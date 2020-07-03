package com.boredream.AlgBase;

import java.util.Arrays;

/**
 * 字符串相关算法
 */
public class StringAlg {


    public static void main(String[] args) {
        lsd();
    }

    /**
     * 键索引计数法
     */
    static void keyIndexCount() {
        // 适合于多个数据分属于少个索引组里的归类排序方法
        KV[] a = new KV[]{
                new KV(2, "bbbbb"),
                new KV(1, "aaaaa"),
                new KV(3, "cc"),
                new KV(3, "ccc"),
                new KV(3, "cccccccc"),
                new KV(4, "dd"),
                new KV(3, "cccccccccc"),
                new KV(2, "bbbbbbb"),
                new KV(2, "bbb"),
                new KV(1, "aa"),
                new KV(4, "ddd"),
                new KV(2, "bbbb"),
                new KV(3, "cccc"),
                new KV(4, "d"),
                new KV(2, "bbbbbb"),
                new KV(3, "cccccccc"),
                new KV(4, "dddd"),
                new KV(1, "aaaa"),
                new KV(4, "dddddd"),
                new KV(4, "dd")};
        int R = 5;

        // step1 计算频率
        int[] count = new int[R + 1]; // 首位永远都是0
        for (KV kv : a) {
            count[kv.key + 1]++;
        }

        // step2 频率转为索引
        for (int i = 0; i < R; i++) {
            count[i + 1] += count[i];
        }

        // step3 将元素按索引排列
        String[] aux = new String[a.length];
        for (KV kv : a) {
            aux[count[kv.key]++] = kv.value;
        }

        // 感觉十分类似于服务端给了一组数，然后app上需要自己归类然后显示在列表里
    }

    /**
     * 低位优先排序
     */
    static void lsd() {
        // 适用于字符串都是同一个长度的情况

        String[] strList = {
                "3124123",
                "1234234",
                "3213214",
                "4123423",
                "1251234",
                "2124234",
                "2498107",
                "4850497",
                "2940957",
                "1239845",
        };
        int N = strList.length;
        int W = strList[0].length();
        String[] aux = new String[N];
        for (int index = W - 1; index >= 0; index--) {
            // 和索引排序一样，只是从低到高位挨个来一轮

            int[] count = new int[257]; // 256 字符 + 1首位是0

            // step1 计算频率
            for (String s : strList) {
                count[s.charAt(index) + 1]++;
            }

            // step2 频率转为索引
            for (int i = 0; i < count.length - 1; i++) {
                count[i + 1] += count[i];
            }

            // step3 元素按索引排列
            for (String s : strList) {
                aux[count[s.charAt(index)]++] = s;
            }

            // step4 回写
            for (int i = 0; i < N; i++) {
                strList[i] = aux[i];
            }
        }

        System.out.println(Arrays.toString(strList));
    }

    static class KV {
        Integer key;
        String value;

        KV(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
