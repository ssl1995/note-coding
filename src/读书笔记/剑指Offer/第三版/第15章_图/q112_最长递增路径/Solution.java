package 读书笔记.剑指Offer.第三版.第15章_图.q112_最长递增路径;

/**
 * @author SongShengLin
 * @date 2021/11/27 4:53 下午
 * @description
 */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // lengths[i][j]：记录从(i,j)最长递增的长度
        int[][] lengths = new int[rows][cols];

        int maxLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int len = dfs(matrix, lengths, i, j);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;

    }

    private int dfs(int[][] matrix, int[][] lengths, int i, int j) {
        if (lengths[i][j] != 0) {
            return lengths[i][j];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int length = 1;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            // 从小数字指向大数字->有向无环图
            if (r >= 0 && r < rows && c >= 0 && c < cols && matrix[i][j] < matrix[r][c]) {
                int len = dfs(matrix, lengths, r, c);
                length = Math.max(len + 1, length);
            }
        }

        lengths[i][j] = length;
        return length;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 4, 5}, {3, 2, 8}, {2, 2, 1}};
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(matrix));
    }
}
