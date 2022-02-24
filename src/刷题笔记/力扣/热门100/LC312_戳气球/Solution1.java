package 刷题笔记.力扣.热门100.LC312_戳气球;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/2/24 12:30 AM
 * @description
 */
public class Solution1 {

    public int[][] dp;
    public int[] arr;

    /**
     * 戳气球
     * 输入：nums = [3,1,5,8]
     * 输出：167
     * 解释：
     * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
     * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // arr保存nums前后不存在的两个数
        arr = new int[n + 2];
        // 初始化前后不存在的两个数
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        // dp[left][right]表示(left,right)开区间上，添加一个气球获得的最大硬币数
        dp = new int[n + 2][n + 2];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }

        return dfs(0, n + 1);

    }

    /**
     * 记忆化搜索：
     */
    private int dfs(int left, int right) {
        // (i,j)是开区间，i>=j-1说明中间无数，结束递归
        if (left >= right - 1) {
            return 0;
        }
        // ≠-1，说明已经缓存，返回即可
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        // 自底向上：每一个位置都尝试填充气球，并计算其相邻最大值
        for (int i = left + 1; i < right; i++) {
            // 相邻3个数乘积
            int sum = arr[left] * arr[i] * arr[right];
            // 获取左右区间最大硬币数
            sum += dfs(left, i) + dfs(i, right);
            dp[left][right] = Math.max(dp[left][right], sum);
        }

        return dp[left][right];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {3, 1, 5, 8};
        System.out.println(solution.maxCoins(nums));
    }

}
