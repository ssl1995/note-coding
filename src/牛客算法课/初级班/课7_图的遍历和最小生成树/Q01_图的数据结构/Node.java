package 牛客算法课.初级班.课7_图的遍历和最小生成树.Q01_图的数据结构;

import java.util.ArrayList;

public class Node {
    public int value;// 值
    public int in;// 入度:指向改点的数量
    public int out;// 出度:从该点出去的数量
    public ArrayList<Node> nexts;// 从改点实际发散出去的点有哪些
    public ArrayList<Edge> edges;// 属于该点的边:从改点出发指向别的点的边,不是指向该点的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
