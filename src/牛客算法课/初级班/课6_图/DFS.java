package 牛客算法课.初级班.课6_图;

import 牛客算法课.初级班.课6_图.图的数据结构.Node;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    // 图的深度优先遍历
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        // DFS先处理头结点，业务逻辑
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    // DFS还要再把cur和next再入栈一遍，保证深度特性
                    stack.push(cur);
                    stack.push(next);
                    // 入栈的next，也要如set保证唯一性
                    set.add(next);
                    // 业务逻辑
                    System.out.println(next.value);
                    // 处理完一个cur.next,重复while循环
                    // 当前for结束
                    break;
                }
            }
        }
    }

}
