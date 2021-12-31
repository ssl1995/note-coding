package 读书笔记.牛客算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构;

public class Edge {
    // 权重
    public int weight;
    // 默认是有向边,无向边可以由有向边组成
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}
