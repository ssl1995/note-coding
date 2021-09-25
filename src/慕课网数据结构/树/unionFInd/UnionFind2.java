package 慕课网数据结构.树.unionFInd;

/**
 * @Author ssl
 * @Date 2020/12/15 17:31
 * @Description
 */
public class UnionFind2 implements UnionFind {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
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
        parent[pRoot] = qRoot;
    }
}
