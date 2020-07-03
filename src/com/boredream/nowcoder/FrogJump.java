package com.boredream.nowcoder;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class FrogJump {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }

    static int JumpFloorII(int target) {
        step(target);
        return count;
    }

    static int count = 0;
    private static void step(int target) {
        if(target == 0) {
            count++;
            return;
        }

        for(int i=1; i<=target; i++) {
            step(target - i);
        }
    }

}
