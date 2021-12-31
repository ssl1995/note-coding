package 学习笔记.剑指Offer.专项突击版.第15章_图.q105_最大的岛屿;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/11/24 9:11 上午
 * @description
 */
public class Solution {

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

    // 广度优先
    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        // 先将起始坐标加入队列
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        // 向上行-1；向下行+1;向左列-1;向右列+1
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 面积初始化为0
        int area = 0;
        while (!queue.isEmpty()) {
            // 广度优先先移除队头
            int[] pos = queue.remove();
            // 由于结点值是1，每访问一个结点，面积+1
            area++;
            for (int[] dir : dirs) {
                // 判断上下左右四个方向的坐标
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                // 如果四个方向某个坐标满足条件，就加入队列并且设置为访问过
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !visited[r][c]) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] gird = {{1, 1, 0, 0, 1}, {1, 0, 0, 1, 0}, {1, 1, 0, 1, 0}, {0, 0, 1, 0, 0}};
        int res = solution.maxAreaOfIsland(gird);
        System.out.println(res);
    }

}
