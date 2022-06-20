package 刷题笔记.力扣.热门100.LC312_戳气球;

/**
 * @author SongShengLin
 * @date 2022/2/24 12:30 AM
 * @description
 */
public class Solution2 {

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
        int[] arr = new int[n + 2];
        // 初始化前后不存在的两个数
        arr[0] = 1;
        arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);

        // dp[left][right]表示(left,right)开区间上，添加一个气球获得的最大硬币数
        int[][] dp = new int[n + 2][n + 2];
        int m = dp.length;
        n = dp[0].length;

        // 自底向上添加气球：每次从i位置往前数3个数
        for (int i = m - 2; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    // [i,j,k]三个位置的乘积
                    int sum = arr[i] * arr[k] * arr[j];
                    // dp[i,k]、dp[k,j]的原有的乘积
                    sum += dp[i][k] + dp[k][j];

                    // 保存最大值
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }

        return dp[0][n - 1];
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {3, 1, 5, 8};
        System.out.println(solution.maxCoins(nums));
    }

}
