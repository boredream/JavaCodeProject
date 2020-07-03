package com.boredream.leetcode;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1025 {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(divisorGame(i));
        }
    }

    static boolean divisorGame(int N) {
        // 思路，dp = 在某个数字时，谁先拿必赢的情况
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            boolean win = false;
            // i = 当前钱数
            for (int j = 1; j <= i / 2; j++) {
                // 尝试整除，到一半即可
                if(i % j == 0){
                    // 计算整除后剩余钱数的胜利情况
                    if(!dp[i - j]) {
                        // 如果剩余情况是爱丽丝赢，则当前情况是爱丽丝输（相当于先后手顺序调过来），反之亦然
                        win = true;
                        break;
                    }
                }
            }
            dp[i] = win;
        }
        return dp[N];
    }
}
