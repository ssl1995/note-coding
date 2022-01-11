package 学习笔记.数据结构与算法之美.第7章_跳表_并查集_线段树和树状数组.并查集.基于链表;

/**
 * @author SongShengLin
 * @date 2022/1/12 1:05 AM
 * @description
 */
public class LinkedUnionFindSet {
    private Node[] nodes;

    public LinkedUnionFindSet(int n) {
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
    }

    /**
     * 合并
     */
    public void union(int i, int j) {
        if (find(i, j)) {
            return;
        }
        Node iHead = nodes[i].R;
        Node iTail = iHead.pre;
        Node jHead = nodes[j].R;
        Node jTail = jHead.pre;

        // 两个双向链表首尾相连
        iTail.next = jHead;
        jHead.pre = iTail;
        jTail.pre = iHead;
        iHead.pre = jTail;

        // 跟进j链表的R和iHead的R对齐
        Node p = jHead;
        while (p != jTail) {
            p.R = iHead.R;
        }
        jTail.R = jHead.R;

    }

    /**
     * 查找
     */
    public boolean find(int i, int j) {
        return nodes[i].R == nodes[j].R;
    }
}
