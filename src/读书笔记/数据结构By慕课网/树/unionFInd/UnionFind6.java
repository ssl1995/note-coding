package 读书笔记.数据结构By慕课网.树.unionFInd;

/**
 * @Author ssl
 * @Date 2020/12/15 17:31
 * @Description
 */
public class UnionFind6 implements UnionFind {

    private int[] parent;
    // 优化：rank存parent[i]上的挂着的层数
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("p is not of bound");
        }
        // 递归实现压缩路径
        if (p != parent[p]) {
            parent[p]=find(parent[p]);
        }
        // 返回整颗数的根节点
        return parent[p];
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {

        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            // rank[qRoot] == rank[pRoot]
            parent[qRoot] = pRoot;
            // 只有等于，才需要让根节点深度+1
            rank[pRoot] += 1;
        }
    }
}
