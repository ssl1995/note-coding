package 剑指Offer.专项突击版.第15章_图.q105_最大的岛屿;

/**
 * @author SongShengLin
 * @date 2021/11/24 9:11 上午
 * @description
 */
public class Solution2 {

    // 求最大岛屿的面积
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 将所有1组成的结点看成一个个联通子图，用visited记录是否访问过
                if (grid[i][j] == 1 && !visited[i][j]) {
                    // 选择广度优先or深度优先
                    int area = getArea(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    // 基于递归实现深度优先搜索
    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        // 递归初始化面积为1
        int area = 1;

        // 向上行-1；向下行+1;向左列-1;向右列+1
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 面积初始化为0

        for (int[] dir : dirs) {
            // 判断上下左右四个方向的坐标
            int r = i + dir[0];
            int c = j + dir[1];
            // 如果四个方向某个坐标满足条件，就加入队列并且设置为访问过
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !visited[r][c]) {
                // 每递归一次，面积+1
                area += getArea(grid, visited, r, c);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] gird = {{1, 1, 0, 0, 1}, {1, 0, 0, 1, 0}, {1, 1, 0, 1, 0}, {0, 0, 1, 0, 0}};
        int res = solution.maxAreaOfIsland(gird);
        System.out.println(res);
    }

}
