package com.boredream.AlgBase;

import com.intellij.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 排列算法(回溯法)
 */
public class Permutation {

    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }

    static ArrayList Permutation(String str) {
        ArrayList res = new ArrayList();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    static void PermutationHelper(char[] cs, int k, ArrayList list) {
        if (k == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                System.out.println("add " + String.valueOf(cs));
                list.add(val);
        } else {
            for (int i = k; i < cs.length; ++i) {
                System.out.println("k=" + k + " ... i=" + i + " ... before= " + String.valueOf(cs));
                ArrayUtil.swap(cs, k, i);
                System.out.println("k=" + k + " ... i=" + i + " ... swap1= " + String.valueOf(cs));
                PermutationHelper(cs, k + 1, list);
                ArrayUtil.swap(cs, k, i);
                System.out.println("k=" + k + " ... i=" + i + " ... swap2= " + String.valueOf(cs));
            }
        }
    }

}
