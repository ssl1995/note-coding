package 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q02_图的遍历;

import 牛客.算法课.基础班.课7_图的遍历和最小生成树.Q01_图的数据结构.Node;

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
        System.out.println(node.value);// 遍历前处理根节点
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur); // cur和next都要再次入栈,保证栈中保持深度优先的路径
                    stack.push(next);
                    set.add(next);// next加入set保证无环
                    System.out.println(next.value);
                    break;// 深度优先只处理第一个处理的next结点,其余不处理跳出
                }
            }
        }
    }

}
