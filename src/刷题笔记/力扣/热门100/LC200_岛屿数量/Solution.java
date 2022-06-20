package 刷题笔记.力扣.热门100.LC200_岛屿数量;

/**
 * @author SongShengLin
 * @date 2022/6/18 17:08
 * @description
 */
public class Solution {

    /**
     * 岛屿数量
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);

                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // base case：越界
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return;
        }
        // base case：未遍历的陆地
        if (grid[i][j] != '1') {
            return;
        }
        // 感染已经遍历过的格子
        grid[i][j] = '2';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
