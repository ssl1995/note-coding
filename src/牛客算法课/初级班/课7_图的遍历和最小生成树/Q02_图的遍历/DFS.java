package 牛客算法课.初级班.课7_图的遍历和最小生成树.Q02_图的遍历;

import 牛客算法课.初级班.课7_图的遍历和最小生成树.Q01_图的数据结构.Node;

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
        // 深度优先在循环前就处理初试结点node
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    // 深度优先遍历如果set中没有next结点
                    // cur和next都要再次入栈,保证栈中保持深度优先的路径
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);// next加入set保证无环
                    // 业务逻辑
                    System.out.println(next.value);
                    // 处理完一个cur.next,重复while循环
                    // 深度优先只处理第一个处理的next结点,其余不处理跳出
                    break;
                }
            }
        }
    }

}
