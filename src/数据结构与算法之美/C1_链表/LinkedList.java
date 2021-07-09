package 数据结构与算法之美.C1_链表;

public class LinkedList {
    public class Node {
        public int data;
        public Node next;
    }

    private Node head = null;
    // 使用哨兵记录单链表的尾结点
    private Node tail = null;

    public LinkedList() {
        // 使用哨兵,统一insertAtTail代码
        Node guard = new Node();
        head = guard;
        tail = guard;
    }

    public void insert(Node b, Node x) {
        if (b == null) {
            x.next = head;// 头插法
            head = x;
        } else {
            x.next = b.next;
            b.next = x;
        }
    }

    public void remove(Node a, Node b) {// 删除b,已知b前序是a
        if (a == null) {
            head = head.next;
        } else {
            a.next = a.next.next;
        }
    }

    public void remove(int val) {
        Node q = head;
        Node p = null;
        while (q != null & q.data != val) {
            p = q;
            q = q.next;
        }
        if (q != null) {
            if (p == null) {
                head = head.next;
            } else {
                p.next = q.next;
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
        Node p = head;
        while (p.next != null && p.next != q) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = q.next;
        }
    }


    public Node find(Node x) {
        Node p = head;
        while (p != null && p.data != x.data) {
            p = p.next;
        }
        return p;
    }

    public Node get(int k) {
        Node p = head;
        int i = 0;
        while (p != null && i != k) {
            p = p.next;
            i++;
        }
        return p;
    }

    public void insertAtTail(Node newNode) {
        tail.next = newNode;
        newNode.next = head;
    }


}
