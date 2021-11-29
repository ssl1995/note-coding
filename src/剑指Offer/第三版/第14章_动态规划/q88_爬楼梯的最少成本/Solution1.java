package 剑指Offer.第三版.第14章_动态规划.q88_爬楼梯的最少成本;

/**
 * @author SongShengLin
 * @date 2021/11/14 1:01 上午
 * @description
 */
public class Solution1 {
    // Q:数组都是正数，第i个数字代表爬上第i个台阶的代价，初始化可以从第0个台阶、或者第1个台阶向上爬，问爬上该楼梯的最小成本？
    // 自上而下，从大问题入手，使用dp
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len <= 2) {
            return len == 1 ? cost[0] : Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[len];
        helper(cost, dp, len - 1);
        return Math.min(dp[len - 2], dp[len - 1]);
    }

    private void helper(int[] cost, int[] dp, int i) {
        if (i < 2) {
            dp[i] = cost[i];
        } else if (dp[i] == 0) {// cost都是正数，说明==0没有缓存过
            helper(cost, dp, i - 2);
            helper(cost, dp, i - 1);
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
    }

    public static void main(String[] args) {
        int[] cost = {1, 100};
        Solution1 solution = new Solution1();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
