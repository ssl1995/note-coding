package 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q04_最小生成树;


import 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构.Edge;
import 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构.Graph;
import 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    public static Set<Edge> primMST(Graph graph) {
        // 1.优先级队列按照边的权值从小到大排序
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        // 2.set表示结点是否用过
        HashSet<Node> set = new HashSet<>();
        // 3.结果集
        Set<Edge> result = new HashSet<>();
        // 4.遍历图中所有结点
        // for防止森林存在，也返回最小生成树
        for (Node node : graph.nodes.values()) {
            // 5.如果set中无该节点
            if (!set.contains(node)) {
                set.add(node);
                // 6.一个点解锁所有的边，入队列
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                // 7.队列出队，该边toNode不在set中，就入set和结果集
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        // 8.队列中入nextEdge
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

    // 请保证graph是连通图
    // graph[i][j]表示点i到点j的距离，如果是系统最大值代表无路
    // 返回值是最小连通图的路径之和
    public static int prim(int[][] graph) {
        int size = graph.length;
        int[] distances = new int[size];
        boolean[] visit = new boolean[size];
        visit[0] = true;
        for (int i = 0; i < size; i++) {
            distances[i] = graph[0][i];
        }
        int sum = 0;
        for (int i = 1; i < size; i++) {
            int minPath = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distances[j] < minPath) {
                    minPath = distances[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) {
                return sum;
            }
            visit[minIndex] = true;
            sum += minPath;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distances[j] > graph[minIndex][j]) {
                    distances[j] = graph[minIndex][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("hello world!");
    }

}
