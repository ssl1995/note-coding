package 学习笔记.极客时间.数据结构与算法之美.第7章_跳表_并查集_线段树和树状数组.并查集.基于链表;

/**
 * @author SongShengLin
 * @date 2022/1/12 1:27 AM
 * @description
 */
public class TreeUnionFindSet {
    /**
     * 基于数组记录树的父节点
     */
    private int p[];

    /**
     * 基于树的高度表示每个结点的秩
     */
    private int rank[];

    public TreeUnionFindSet(int n) {
        p = new int[n];
        rank = new int[n];
        // 初始化每个节点的父节点：初始化时节点父就是它本身
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        // 初始化秩：每个结点高度为1
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
        }
    }

    /**
     * 合并：按秩合并是在这一步优化
     */
    public void union(int i, int j) {
        if (find(i, j)) {
            return;
        }
        // 秩小的挂在秩大的下面
        if (rank[i] < rank[j]) {
            p[i] = j;
        } else if (rank[i] > rank[j]) {
            p[j] = i;
        } else {
            // 秩相同，选一个挂，挂的秩要+1
            p[i] = j;
            rank[j]++;
        }
    }

    /**
     * 查找：路径优化是在这一步优化
     */
    public boolean find(int i, int j) {
        return findR(i) == findR(j);
    }

    /**
     * 找i的归属结点=压缩路径
     */
    private int findR(int i) {
        if (p[i] != i) {
            p[i] = findR(p[i]);
        }
        return p[i];
    }


}
