package 牛客算法课.初级班.课6_图;


import 牛客算法课.初级班.课6_图.图的数据结构.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // 图的Breadth First Search宽度优先遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // 记录节点不能重复加入queue
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 业务代码
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }

}
