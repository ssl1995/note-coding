package 牛客算法课.初级班.课6_图;


import 牛客算法课.初级班.课6_图.图的数据结构.Edge;
import 牛客算法课.初级班.课6_图.图的数据结构.Graph;
import 牛客算法课.初级班.课6_图.图的数据结构.Node;

import java.util.*;

public class Kruskal {
    // Kruskal克里斯卡尔算法：只针对无向图，生成最小生成树
    // 实现一个并查集
    public static class UnionFind {
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> rankMap;

        public UnionFind() {
            fatherMap = new HashMap<Node, Node>();
            rankMap = new HashMap<Node, Integer>();
        }

        private Node findFather(Node n) {
            Node father = fatherMap.get(n);
            if (father != n) {
                father = findFather(father);
            }
            fatherMap.put(n, father);
            return father;
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            rankMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if (aFather != bFather) {
                int aFrank = rankMap.get(aFather);
                int bFrank = rankMap.get(bFather);
                if (aFrank <= bFrank) {
                    fatherMap.put(aFather, bFather);
                    rankMap.put(bFather, aFrank + bFrank);
                } else {
                    fatherMap.put(bFather, aFather);
                    rankMap.put(aFather, aFrank + bFrank);
                }
            }
        }
    }

    public static Set<Edge> kruskalMST(Graph graph) {
        // 1.并查集存所有结点
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        // 2.优先级队列按照边的权值从小到大排序
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        // 3.结果集
        Set<Edge> result = new HashSet<>();
        // 4.遍历队列
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            // 5.如果并查集中不包含出队的边的form结点和to结点，就入结果集,并且合并并查集
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
