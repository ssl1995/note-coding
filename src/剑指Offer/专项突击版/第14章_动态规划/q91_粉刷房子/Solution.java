package 剑指Offer.专项突击版.第14章_动态规划.q91_粉刷房子;

/**
 * @author SongShengLin
 * @date 2021/11/15 9:33 上午
 * @description
 */
public class Solution {

    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[3][2];
        // 初始化,比如r(0)=costs[0]
        for (int i = 0; i < 3; i++) {
            dp[i][0] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                int prev1 = dp[(j + 1) % 3][(i - 1) % 2];
                int prev2 = dp[(j + 2) % 3][(i - 1) % 2];
                dp[j][i % 2] = Math.min(prev1, prev2) + costs[i][j];
            }
        }

        int last = (costs.length - 1) % 2;
        return Math.min(dp[0][last], Math.min(dp[1][last], dp[2][last]));
    }

    public static void main(String[] args) {
        int[][] costs = {{17, 2, 16}, {15, 14, 5}, {13, 3, 1}};
        Solution solution = new Solution();
        System.out.println(solution.minCost(costs));
    }
}
