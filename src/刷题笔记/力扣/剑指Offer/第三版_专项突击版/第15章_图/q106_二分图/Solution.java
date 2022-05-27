package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第15章_图.q106_二分图;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/11/25 12:29 上午
 * @description
 */
public class Solution {
    /**
     * 二分图：如果能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合
     */
    public boolean isBipartite(int[][] graph) {
        // graph[][]的行坐标就是结点个数
        int size = graph.length;
        int[] colors = new int[size];
        // 没涂颜色用-1标识
        Arrays.fill(colors, -1);

        for (int i = 0; i < size; i++) {
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 广度优先搜索
     * setColor表示以i为起始结点的一个联通子图着色
     *
     * @return 能否按照二分图的规则对子图所有结点着色
     */
    private boolean setColor(int[][] graph, int[] colors, int i, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = color;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int neighbor : graph[v]) {
                // 相邻结点如果被涂上颜色，就判断与当前结点是否颜色相同
                // 相同，说明不能构成二分图
                if (colors[neighbor] >= 0) {
                    if (colors[neighbor] == colors[v]) {
                        return false;
                    }
                } else {// 不相同，说明有机会构成二分图
                    queue.add(neighbor);
                    // 涂的颜色用0和1来区分，没涂颜色用-1标识
                    colors[neighbor] = 1 - colors[v];
                }
            }
        }
        return true;
    }
}
