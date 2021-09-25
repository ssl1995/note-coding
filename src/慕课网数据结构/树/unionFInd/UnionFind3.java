package 慕课网数据结构.树.unionFInd;

/**
 * @Author ssl
 * @Date 2020/12/15 17:31
 * @Description
 */
public class UnionFind3 implements UnionFind {

    private int[] parent;
    // 优化：sz存parent[i]上的挂着的元素个数
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("p is not of bound");
        }
        // 一直找父节点
        while (p != parent[p]) {
            p = parent[p];
        }
        // 直到父节点指向自己，就返回
        return p;
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
        if (sz[pRoot] < sz[qRoot]) {
            // 小个数的结点指向大个数的
            parent[pRoot] = qRoot;
            // 大个数的节点数加上小个数的节点数
            sz[qRoot] += sz[pRoot];
        } else {
            // 小个数的结点指向大个数的
            parent[qRoot] = pRoot;
            // 大个数的节点数加上小个数的节点数
            sz[pRoot] += sz[qRoot];
        }
    }
}
