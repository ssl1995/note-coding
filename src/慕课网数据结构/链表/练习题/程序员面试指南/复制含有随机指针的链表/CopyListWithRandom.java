package 慕课网数据结构.链表.练习题.程序员面试指南.复制含有随机指针的链表;

import java.util.HashMap;

public class CopyListWithRandom {
    // 与力扣138相同
    // 方法1:使用哈希表，但是力扣138会超时
    public Node copyListWithRandom1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }

    // 方法2:复制结点放到每个结点的后面
    public Node copyListWithRandom2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;
        // 1. 每个结点后面连接复制的结点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // 2.将复制结点的random赋值
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            // 复制结点的random指向cur的random.next
            curCopy.random = (cur.random != null) ? cur.random.next : null;
            cur = next;
        }
        // 3.拆分，使复制结点的next指向自己的next
        cur = head;
        Node res = head.next;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = (next != null) ? next.next : null;
            cur = next;
        }
        return res;

    }

}
