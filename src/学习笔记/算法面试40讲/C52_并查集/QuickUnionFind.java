package 学习笔记.算法面试40讲.C52_并查集;

/**
 * @author SongShengLin
 * @date 2022/2/20 4:35 PM
 * @description
 */
public class QuickUnionFind {

    private int[] roots;

    public QuickUnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    private int findRoot(int i) {
        // 找出最大的老大
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }
        // 路径压缩，i经过的所有结点都指向老大
        while (i != roots[i]) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        // 返回老大
        return root;
    }

    private boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private void union(int p, int q) {
        int root1 = findRoot(p);
        int root2 = findRoot(q);
        roots[root2] = root1;
    }


}
