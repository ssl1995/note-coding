package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q60_n个骰子的点数;

import java.util.Arrays;

public class Solution {

    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
     * 输入n，打印出s的所有可能的值出现的概率。
     */
    public double[] dicesProbability(int n) {
        // 初始化第1个骰子:点数和总数为6个,概率都为1.0/6.0
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        // 计算第2个到第n个骰子的点数和概率
        for (int i = 2; i <= n; i++) {
            // 1个骰子:6种点数和总数;2个骰子:6+5种点数和总数;
            // 点数和总数：5n+1
            double[] next = new double[5 * i + 1];
            // 正向遍历上一轮dp
            for (int j = 0; j < dp.length; j++) {
                // 每6个数,遍历这一轮的next数组
                for (int k = j; k < j + 6; k++) {
                    // 上一轮的dp[j]对它之后的每6个数都产生了dp[j]/6.0的影响
                    next[k] += dp[j] / 6.0;
                }
            }
            // 上一轮的dp数组更新为这一轮的next数组
            dp = next;
        }
        return dp;
    }
}
