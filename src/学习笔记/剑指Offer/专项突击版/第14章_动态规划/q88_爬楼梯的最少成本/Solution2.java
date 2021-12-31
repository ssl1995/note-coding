package 学习笔记.剑指Offer.专项突击版.第14章_动态规划.q88_爬楼梯的最少成本;

/**
 * @author SongShengLin
 * @date 2021/11/14 1:01 上午
 * @description
 */
public class Solution2 {
    // Q:数组都是正数，第i个数字代表爬上第i个台阶的代价，初始化可以从第0个台阶、或者第1个台阶向上爬，问爬上该楼梯的最小成本？
    // 空间复杂度O(n)
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[len - 2], dp[len - 1]);
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 100, 1};
        Solution2 solution = new Solution2();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
