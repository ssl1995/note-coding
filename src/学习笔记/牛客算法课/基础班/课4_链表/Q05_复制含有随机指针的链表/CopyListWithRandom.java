package 学习笔记.牛客算法课.基础班.课4_链表.Q05_复制含有随机指针的链表;

import java.util.HashMap;

public class CopyListWithRandom {
    // Node：含有rand随机指针
    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int data) {
            this.val = data;
        }
    }

    // 方法一：使用HashMap复制结点
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    // 方法2：不使用HashMap,直接在当前节点位置复制结点
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;
        // 1.原链表每个结点后面都复制一个当前节点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy;
        // 2.更新克隆结点的random指针
        while (cur != null) {
            next = cur.next.next;// 记录下一个cur
            curCopy = cur.next;// cur,curCopy进行random复制
            curCopy.random = cur.random != null ? cur.random.next : null;// cur.random.next=curCopy.random
            cur = next;
        }
        Node newHead = head.next;
        cur = head;
        // 3.分离原结点和克隆结点，next得以保证
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return newHead;
    }
}
