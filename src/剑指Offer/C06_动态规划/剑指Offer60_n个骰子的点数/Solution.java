package 剑指Offer.C06_动态规划.剑指Offer60_n个骰子的点数;

import java.util.Arrays;

public class Solution {

    public double[] dicesProbability(int n) {
        // 初始化第1个骰子:点数和总数为6个,概率都为1.0/6.0
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        // 计算第2个到第n个骰子的点数和概率
        for (int i = 2; i <= n; i++) {
            // 1个骰子:6种点数和;2个骰子:6+5种点数和
            // n个骰子:6+(n-1)*5=5n+1种点数和
            double[] next = new double[5 * i + 1];
            // 遍历上一轮的dp数组
            for (int j = 0; j < dp.length; j++) {
                // 每6个数,遍历这一轮的next数组
                for (int k = 0; k < 6; k++) {
                    // 上一轮的dp[j]对它之后的每6个数都产生了dp[j]/6.0的影响
                    next[j + k] += dp[j] / 6.0;
                }
            }
            // 上一轮的dp数组更新为这一轮的next数组
            dp = next;
        }
        return dp;
    }
}
