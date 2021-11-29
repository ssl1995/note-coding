package 剑指Offer.第三版.第14章_动态规划.q88_爬楼梯的最少成本;

/**
 * @author SongShengLin
 * @date 2021/11/14 1:01 上午
 * @description
 */
public class Solution {
    // Q:数组都是正数，第i个数字代表爬上第i个台阶的代价，初始化可以从第0个台阶、或者第1个台阶向上爬，问爬上该楼梯的最小成本？
    // 暴力递归
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(cost, cost.length - 1), helper(cost, cost.length - 2));
    }

    private int helper(int[] cost, int i) {
        if (i < 2) {
            return cost[i];
        }
        // 转移方程:f(i)=min(f(i-1),f(i-2))+cost[i]
        return Math.min(helper(cost, i - 1), helper(cost, i - 2)) + cost[i];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 100, 1};
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
