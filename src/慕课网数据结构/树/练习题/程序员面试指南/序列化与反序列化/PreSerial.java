package 慕课网数据结构.树.练习题.程序员面试指南.序列化与反序列化;

import java.util.LinkedList;

public class PreSerial {

    // 序列化
    public String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    // 反序列化
    public Node reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    //
    private Node reconPreOrder(LinkedList<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
