package 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构;

public class GraphGenerator {
    // 转换成自己图结构的接口:使用自己的数据结构,模拟生成一个图
    // 假设matrix二维数组[[权重，fromNode，toNode]...]
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            // 1.获得条件中的数据项
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            // 2.图中加入节点
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            // 3.创建from、to、edge
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);// from的直接连接节点是to
            fromNode.out++;// from的出度+1
            toNode.in++;// to的入读+1
            // 3.from连接edge,graph连接edge
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

}
