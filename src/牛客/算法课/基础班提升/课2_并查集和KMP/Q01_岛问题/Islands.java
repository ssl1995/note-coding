package 牛客.算法课.基础班提升.课2_并查集和KMP.Q01_岛问题;

public class Islands {

    // 岛屿问题:参数是二维字符数组
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
                    res++;
                    infect(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    private void infect(char[][] grid, int i, int j, int m, int n) {
        // base case:i,j越界,且遇到0或者2就停止
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        // 感染到的岛屿全部设置为2,再次遇到2,就不会res+1
        grid[i][j] = '2';
        infect(grid, i + 1, j, m, n);
        infect(grid, i - 1, j, m, n);
        infect(grid, i, j + 1, m, n);
        infect(grid, i, j - 1, m, n);
    }
}
