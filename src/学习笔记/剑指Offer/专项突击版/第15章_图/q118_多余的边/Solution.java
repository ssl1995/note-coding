package 学习笔记.剑指Offer.专项突击版.第15章_图.q118_多余的边;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2021/11/29 4:06 下午
 * @description
 */
public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int max = 0;
        for (int[] edge : edges) {
            max = Math.max(max, edge[0]);
            max = Math.max(max, edge[1]);
        }

        int[] fathers = new int[max + 1];
        for (int i = 1; i < fathers.length; i++) {
            fathers[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(fathers, edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[2];

    }

    /**
     * 合并i和j所在子图
     */
    private boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            // 合并两个子集
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }

    /**
     * 查找一个结点i的根节点
     */
    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            // 压缩路径，记录每个结点的根节点
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {2, 5}};
        System.out.println(Arrays.toString(solution.findRedundantConnection(edges)));
    }
}
