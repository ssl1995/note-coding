package 牛客算法课.初级班.课6_图.图的数据结构;

import java.util.ArrayList;

public class Node {
    public int value;// 值
    public int in;// 入度
    public int out;// 出度
    public ArrayList<Node> nexts;// 发散出去直接连接的点
    public ArrayList<Edge> edges;// 当前节点包含的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
