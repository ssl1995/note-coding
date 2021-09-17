package 牛客.刷题.NC59_最小路径和;

public class Solution {

    // dp二维
    public int minPathSum1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        // 思考转移方程：dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j]
        // 初始化第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        // 普遍情况：
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // dp一维
    public int minPathSum2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        // 找出行列的最小值，生成一维辅助数组
        int more = Math.max(matrix.length, matrix[0].length);
        int less = Math.min(matrix.length, matrix[0].length);
        int[] dp = new int[less];
        dp[0] = matrix[0][0];
        boolean moreIsRow = (more == matrix.length);
        // 假设行>列数
        // 先初始化第一行
        for (int i = 1; i < less; i++) {
            dp[i] = dp[i - 1] + (moreIsRow ? matrix[0][i] : matrix[i][0]);
        }
        // 从第二行开始更新dp
        for (int i = 1; i < more; i++) {
            // 更新一维dp第一个元素
            dp[0] = dp[0] + (moreIsRow ? matrix[i][0] : matrix[0][i]);
            for (int j = 1; j < less; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + (moreIsRow ? matrix[i][j] : matrix[j][i]);
            }
        }
        return dp[less - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };
        //{1,3,1,0,6,1,0}是路径和最小的，返回12
        System.out.println(solution.minPathSum1(arr));
        System.out.println(solution.minPathSum2(arr));
    }
}
