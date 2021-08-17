package 牛客.NC109_岛屿数量;

public class Solution {
    public int solve(char[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    private void infect(char[][] grid, int i, int j, int m, int n) {
        if (i <= -1 || i >= m || j <= -1 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infect(grid, i + 1, j, m, n);
        infect(grid, i - 1, j, m, n);
        infect(grid, i, j + 1, m, n);
        infect(grid, i, j - 1, m, n);
    }
}
