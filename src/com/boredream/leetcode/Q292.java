package com.boredream.leetcode;

/**
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * <p>
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nim-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q292 {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + " : " + canWinNim(i));
        }
    }

    static boolean canWinNim2(int n) {
        if (n <= 3) return true;
        // 大航海4里有这个！反推，dp[1] 表示剩1个石头时，我先拿是赢是输
        boolean[] win = new boolean[n + 1];
        win[1] = true;
        win[2] = true;
        win[3] = true;
        for (int i = 4; i <= n; i++) {
            boolean take1 = win[i - 1];
            boolean take2 = win[i - 2];
            boolean take3 = win[i - 3];
            // 三种情况，剩下后是对方先手拿，如果是false就代表他先手会输，那我就是赢~ 所以这仨里面只要有一个false就可以
            win[i] = !(take1 && take2 && take3);
        }
        // FIXME 超出内存，则直接仨变量即可
        return win[n];
    }

    static boolean canWinNim1(int n) {
        if (n <= 3) return true;
        boolean pre3 = true;
        boolean pre2 = true;
        boolean pre1 = true;
        for (int i = 4; i <= n; i++) {
            boolean newWin = !(pre3 && pre2 && pre1);
            pre3 = pre2;
            pre2 = pre1;
            pre1 = newWin;
        }
        // FIXME 超出时间限制
        return pre1;
    }

    static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}
