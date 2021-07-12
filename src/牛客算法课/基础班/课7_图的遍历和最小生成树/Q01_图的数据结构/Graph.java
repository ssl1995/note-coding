package 牛客算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    // 点集：<编号，点的实际数据结构(这里以Node为例)>
    public HashMap<Integer, Node> nodes;
    // 边集：<边的数据结构>
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
