package 牛客算法课.基础班.课7_图的遍历和最小生成树.Q02_图的遍历;


import 牛客算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // 图的宽度优先遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        // 宽度优先遍历使用队列
        Queue<Node> queue = new LinkedList<>();
        // 记录节点不能重复加入queue,不会形成环导致死循环
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 业务代码自己替换
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                // map中没有重复才加入
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }

}
