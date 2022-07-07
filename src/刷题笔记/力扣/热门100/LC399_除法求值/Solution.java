package 刷题笔记.力扣.热门100.LC399_除法求值;

import java.util.*;

public class Solution {
    /**
     * 除法求值
     * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     * 注意：
     * 提示：
     * 1 <= equations.length <= 20
     * equations[i].length == 2
     * 1 <= Ai.length, Bi.length <= 5
     * values.length == equations.length
     * 0.0 < values[i] <= 20.0
     * 1 <= queries.length <= 20
     * queries[i].length == 2
     * 1 <= Cj.length, Dj.length <= 5
     * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 条件：1 <= equations.length <= 20，1 <= queries.length <= 20。两者都是非0，减少边界判断
        int n = equations.size();
        // 1.初始化并查集
        UnionFind unionFind = new UnionFind(2 * n);
        // 由于subList中不是单纯的1-26个小写字母，可能是ab,wes这种组合字母
        // 由于并查集底层使用数组实现，所以利用a->0,ab->99这种map映射关系
        // 不能用简单的 字母 -'a'映射关系
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (int i = 0; i < n; i++) {
            List<String> subList = equations.get(i);
            String v1 = subList.get(0);
            String v2 = subList.get(1);

            if (!map.containsKey(v1)) {
                map.put(v1, id++);
            }
            if (!map.containsKey(v2)) {
                map.put(v2, id++);
            }
            // 并查集初始化节点之间关系
            unionFind.union(map.get(v1), map.get(v2), values[i]);
        }

        int resLen = queries.size();
        double[] res = new double[resLen];
        for (int i = 0; i < resLen; i++) {
            List<String> subQuery = queries.get(i);
            Integer v1 = map.get(subQuery.get(0));
            Integer v2 = map.get(subQuery.get(1));

            if (Objects.isNull(v1) || Objects.isNull(v2)) {
                res[i] = -1.0D;
            } else {
                res[i] = unionFind.isConnected(v1,v2);
            }
        }

        return res;
    }

    private static class UnionFind {

        /**
         * a/b =2.0，a的直接父节点是b
         */
        public int[] parent;

        /*
         * a/b =2.0,weight[a]=2.0
         */
        public double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            // 初始化：自己指向自己，自己/自己 = 1.0
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0D;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                // 路径压缩
                int rootX = parent[x];
                parent[x] = find(rootX);
                weight[x] *= weight[rootX];
            }
            return parent[x];
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            // 画图推结果
            parent[rootX] = rootY;
            weight[rootX] = (value * weight[y]) / weight[x];
        }


        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                // 相同根，返回除的结果
                return weight[x] / weight[y];
            } else {
                return -1.0D;
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = new ArrayList<>();
        List<String> subList1 = new ArrayList<>();
        subList1.add("a");
        subList1.add("b");
        List<String> subList2 = new ArrayList<>();
        subList2.add("b");
        subList2.add("c");
        equations.add(subList1);
        equations.add(subList2);

        double[] values = {2.0D, 3.0D};

        List<List<String>> queries = new ArrayList<>();
        List<String> subQueries1 = new ArrayList<>();
        subQueries1.add("a");
        subQueries1.add("c");

        List<String> subQueries2 = new ArrayList<>();
        subQueries2.add("b");
        subQueries2.add("a");

        List<String> subQueries3 = new ArrayList<>();
        subQueries3.add("a");
        subQueries3.add("e");

        List<String> subQueries4 = new ArrayList<>();
        subQueries4.add("a");
        subQueries4.add("a");

        List<String> subQueries5 = new ArrayList<>();
        subQueries5.add("x");
        subQueries5.add("x");
        queries.add(subQueries1);
        queries.add(subQueries2);
        queries.add(subQueries3);
        queries.add(subQueries4);
        queries.add(subQueries5);

        double[] doubles = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));


    }

}
