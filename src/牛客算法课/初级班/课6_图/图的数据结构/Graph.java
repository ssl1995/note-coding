package 牛客算法课.初级班.课6_图.图的数据结构;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    // 点集：<编号，点的数据结构>
    public HashMap<Integer, Node> nodes;
    // 边集：<边的数据结构>
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
