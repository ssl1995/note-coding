package 读书笔记.剑指Offer.专项突击版.第14章_动态规划.q88_爬楼梯的最少成本;

/**
 * @author SongShengLin
 * @date 2021/11/14 1:01 上午
 * @description
 */
public class Solution3 {
    // Q:数组都是正数，第i个数字代表爬上第i个台阶的代价，初始化可以从第0个台阶、或者第1个台阶向上爬，问爬上该楼梯的最小成本？
    // f(i)=min(f(i-1)+f(i-2))+cost[i]
    // 实际上dp数组只需要2位即可, 空间复杂度O(1)
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[]{cost[0], cost[1]};
        for (int i = 2; i < cost.length; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] cost = {0, 0, 0, 1};
        Solution3 solution = new Solution3();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
