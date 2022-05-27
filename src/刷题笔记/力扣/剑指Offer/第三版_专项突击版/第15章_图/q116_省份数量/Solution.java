package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第15章_图.q116_省份数量;

/**
 * @author SongShengLin
 * @date 2021/11/28 10:56 下午
 * @description
 */
public class Solution {
    /**
     * 省份数量
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     */
    public int findCircleNum(int[][] isConnected) {
        // 初始化并查集
        int[] roots = new int[isConnected.length];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        // isConnected是N*N的，有几行就有几个城市
        // 初始化省份数量
        int count = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                // 省份间相互连通，连通的省份数量减1
                if (isConnected[i][j] == 1 && union(roots, i, j)) {
                    count--;
                }
            }
        }
        return count;
    }


    private int find(int[] roots, int i) {
        if (roots[i] != i) {
            roots[i] = find(roots, roots[i]);
        }
        return roots[i];
    }

    private boolean union(int[] roots, int i, int j) {
        int root1 = find(roots, i);
        int root2 = find(roots, j);
        if (root1 != root2) {
            roots[root2] = root1;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.findCircleNum(isConnected));
    }
}
