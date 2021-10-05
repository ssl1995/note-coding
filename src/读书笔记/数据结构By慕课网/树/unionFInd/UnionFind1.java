package 读书笔记.数据结构By慕课网.树.unionFInd;

/**
 * @Author ssl
 * @Date 2020/12/15 17:31
 * @Description
 */
public class UnionFind1 implements UnionFind {
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        // 初始化时，每个数组元素等于其下标=让每个元素都不属于相同分类
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        // 如果两者已经属性同一个集合了，就跳出
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }

    private int find(int p) {
        if (p < 0 || p > id.length) {
            throw new IllegalArgumentException("p is not of bound");
        }
        return id[p];
    }
}
