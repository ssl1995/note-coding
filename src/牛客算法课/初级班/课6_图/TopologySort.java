package 牛客算法课.初级班.课6_图;


import 牛客算法课.初级班.课6_图.图的数据结构.Graph;
import 牛客算法课.初级班.课6_图.图的数据结构.Node;

import java.util.*;

public class TopologySort {

    // directed graph and no loop
    public static List<Node> sortedTopology(Graph graph) {
        // inMap<结点，该节点入度>
        HashMap<Node, Integer> inMap = new HashMap<>();
        // zeroQueue:存放入度为0的结点
        Queue<Node> zeroInQueue = new LinkedList<>();
        // 拓扑排序res
        List<Node> result = new ArrayList<>();
        // 1.遍历图中所有结点，入度为0的入zeroQueue
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        // 2.遍历zeroQueue
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            // 出队列的就入结果集
            result.add(cur);
            // 3.擦地出队结点的影响：入度-1
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                // 4.擦掉后入度=0,就还入zeroQueue
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
