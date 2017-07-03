package com.boredream.leetcode;

/**
 * Created by lichunyang on 2017/7/3.
 */
public class FreedomTrail {

    // TODO: 2017/7/3 error 要考虑左右两个方向的rote

    public static void main(String[] args) {
        String ring = "abcde", key = "ade";
        System.out.println(findRotateSteps(ring, key));
    }

    public static int findRotateSteps(String ring, String key) {
        int keyIndex = 0, ringIndex = 0, step = 0;
        while (true) {
            char keyC = key.charAt(keyIndex);
            char ringC = ring.charAt(ringIndex % ring.length());
            if(keyC == ringC) {
                keyIndex ++;
            } else {
                ringIndex ++;
            }
            step ++;

            if (keyIndex == key.length()) {
                break;
            }
        }
        return step;
    }
}
