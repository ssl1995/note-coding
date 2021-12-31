package 学习笔记.牛客算法课.基础班.课7_图的遍历和最小生成树.Q02_图的遍历;


import 学习笔记.牛客算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构.Node;

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
        HashSet<Node> set = new HashSet<>();// 去重
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);// 替换成自己的业务代码
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

}
