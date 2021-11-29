package 剑指Offer.专项突击版.第15章_图.q111_计算除法;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/11/27 2:56 下午
 * @description
 */
public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String v1 = queries.get(i).get(0);
            String v2 = queries.get(i).get(1);
            // 只有有1个节点不包含在图中，返回-1.0表示失败
            if (!graph.containsKey(v1) || !graph.containsKey(v2)) {
                result[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, v1, v2, visited);
            }
        }
        return result;
    }

    /**
     * 获取有向图，用map表示的邻接表，key是起始结点，value也是一个map，value的key是结束结点，value的value是对应的权重（商）
     */
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String v1 = equations.get(i).get(0);
            String v2 = equations.get(i).get(1);

            graph.putIfAbsent(v1, new HashMap<>());
            graph.get(v1).put(v2, values[i]);

            graph.putIfAbsent(v2, new HashMap<>());
            graph.get(v2).put(v1, 1.0 / values[i]);
        }
        return graph;
    }

    /**
     * 图的深度优先遍历，获取from到to的计算结果
     */
    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        if (from.equals(to)) {
            return 1.0;
        }

        visited.add(from);

        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double nextRes = dfs(graph, next, to, visited);
                // 返回-1就不用返回了；>0才是有效结果
                if (nextRes > 0) {
                    return entry.getValue() * nextRes;
                }
            }
        }
        // 回溯到上一个结点
        visited.remove(from);
        return -1.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>() {{
            add("a");
            add("b");
        }});

        equations.add(new ArrayList<>() {{
            add("b");
            add("c");
        }});

        double[] values = {2.0, 3.0};


        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>() {{
            add("a");
            add("c");
        }});

        queries.add(new ArrayList<>() {{
            add("b");
            add("a");
        }});

        queries.add(new ArrayList<>() {{
            add("a");
            add("e");
        }});

        queries.add(new ArrayList<>() {{
            add("a");
            add("a");
        }});

        queries.add(new ArrayList<>() {{
            add("x");
            add("x");
        }});

        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));

    }
}
