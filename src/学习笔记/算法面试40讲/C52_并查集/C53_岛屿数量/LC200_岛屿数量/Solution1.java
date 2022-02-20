package 学习笔记.算法面试40讲.C52_并查集.C53_岛屿数量.LC200_岛屿数量;

/**
 * @author SongShengLin
 * @date 2022/2/20 4:47 PM
 * @description
 */
public class Solution1 {
    /**
     * 岛屿数量
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 遇见'1'=岛屿，就放入并查集中
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }

    /**
     * 定义并查集数据结构
     */
    class UnionFind {
        int count;
        int[] parent;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            // 铺平成一维
            parent = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        // 有几行，一维数组下标=行数*n+j
                        parent[i * n + j] = i * n + j;
                        // 初始化时，一个'1'表示一个单独岛屿，有几个'1'就有多少个岛屿
                        ++count;
                    }
                }
            }
        }

        public int find(int i) {
            int root = i;
            while (root != parent[root]) {
                root = parent[root];
            }
            // 路径压缩，i经过的所有结点都指向老大
            while (i != parent[i]) {
                int temp = parent[i];
                parent[i] = root;
                i = temp;
            }
            // 返回老大
            return root;
        }

        public void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            if (root1 != root2) {
                parent[root2] = root1;
                // 不相等，连通数-1
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'},};
        System.out.println(solution.numIslands(grid));
    }


}
