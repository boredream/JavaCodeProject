package com.boredream.nowcoder;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 注意不同于FrogJump，只能1或2，那个是1~n
 */
public class JumpFloor {

    public static void main(String[] args) {
        System.out.println(JumpFloor(7));
    }

    static int JumpFloor(int target) {
        // n层只能从n-1和n-2层跳上来，所以fn = fn-1 + fn-2，为斐波那契数列

        // 基础写法如下
//        if (target <= 0) {
//            return -1;
//        } else if (target == 1) {
//            return 1;
//        } else if (target == 2) {
//            return 2;
//        } else {
//            return JumpFloor(target - 1) + JumpFloor(target - 2);
//        }

        // 递归效率太低，可以用迭代计算
        if(target <= 2) return target;
        int t1=1, t2=2;
        int total = 0;
        for (int i = 3; i <= target; i++) {
            total = t1 + t2;
            t1 = t2;
            t2 = total;
        }
        return total;
    }

}
