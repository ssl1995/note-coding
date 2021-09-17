package 力扣.刷题.LC323_零钱兑换;

public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // 根据暴力递归推出动态规划
        int[][] dp = new int[n + 1][amount + 1];
        // 最后一行，除了dp[n][0]是0，其余都是-1
        for (int i = 1; i <= amount; i++) {
            dp[n][i] = -1;
        }
        // 从低往上，倒数第二行开始
        for (int i = n - 1; i >= 0; i--) {// 行
            for (int j = 0; j <= amount; j++) {// 列
                dp[i][j] = -1;
                if (dp[i + 1][j] != -1) {// 如果下面的值有效，先设值为下面的值
                    dp[i][j] = dp[i + 1][j];
                }
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != -1) {// 左边值不越界且有效
                    if (dp[i + 1][j] == -1) {
                        dp[i][j] = dp[i][j - coins[i]] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - coins[i]] + 1);
                    }
                }
            }
        }
        return dp[0][amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Solution1 solution = new Solution1();
        System.out.println(solution.coinChange(coins, amount));
    }
}
