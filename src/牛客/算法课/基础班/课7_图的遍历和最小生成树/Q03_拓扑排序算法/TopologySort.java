package 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q03_拓扑排序算法;


import 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构.Graph;
import 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构.Node;

import java.util.*;

public class TopologySort {

    // 拓扑排序:针对有向图,入度为0的无环结点先打印
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();// inMap<结点，该节点入度>
        Queue<Node> zeroInQueue = new LinkedList<>();// zeroQueue:存放入度为0的结点
        List<Node> result = new ArrayList<>();
        // 1.遍历图中所有结点,记录每个结点和它的入度,并且也记录入度为0的结点
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        // 2.遍历zeroQueue队列
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                // 3.出队结点遍历到的next节点，入度-1
                inMap.put(next, inMap.get(next) - 1);
                // 4.next中入度-1为0的结点，入队列
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
