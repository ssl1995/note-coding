package 数据结构与算法之美.C1_链表;

public class DoublyLinkedList {
    public class Node {
        public int data;
        public Node next;
        public Node pre;
    }


    public Node head = null;

    public void remove(int val) {
        Node q = head;
        while (q != null & q.data != val) {
            q = q.next;
        }
        if (q != null) {
            if (q.pre == null) {
                head = head.next;
            } else {
                q.pre.next = q.next;
            }
        }
    }

    public void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            head = head.next;
            return;
        }
        // 双向链表直接删除
        q.pre.next = q.next;
    }


}
