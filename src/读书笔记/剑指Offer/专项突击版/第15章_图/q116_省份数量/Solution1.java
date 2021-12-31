package 读书笔记.剑指Offer.专项突击版.第15章_图.q116_省份数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/11/28 10:56 下午
 * @description
 */
public class Solution1 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                findCircle(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void findCircle(int[][] isConnected, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int t = queue.remove();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[t][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.findCircleNum(isConnected));
    }
}
