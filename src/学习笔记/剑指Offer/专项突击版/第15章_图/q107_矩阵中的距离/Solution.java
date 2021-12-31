package 学习笔记.剑指Offer.专项突击版.第15章_图.q107_矩阵中的距离;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/11/25 9:21 上午
 * @description
 */
public class Solution {


    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dists = new int[rows][cols];

        // 队列保存mat中元素的坐标
        Queue<int[]> queue = new LinkedList<>();
        // 初始化dists数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    // 初始化时队列只保存值为0的下标
                    queue.add(new int[]{i, j});
                    dists[i][j] = 0;
                } else {// 非0的地方都默认为最大值
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // 上下左右四个方向的坐标
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            // 出队列，获取mat中的坐标
            int[] pos = queue.remove();
            // 计算该坐标目前距离最近0的距离
            int dist = dists[pos[0]][pos[1]];
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    // 广度优先搜索是求最短路径的，如果>dist+1，说明该格子之前没有到达过
                    // 并且该格子离最近的0距离为dist+1
                    if (dists[r][c] > dist + 1) {
                        dists[r][c] = dist + 1;
                        // 队列保存之前保存过的格子坐标
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return dists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(solution.updateMatrix(mat)));
    }
}
