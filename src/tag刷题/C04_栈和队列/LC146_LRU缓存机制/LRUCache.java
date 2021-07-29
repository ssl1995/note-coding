package tag刷题.C04_栈和队列.LC146_LRU缓存机制;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;

        // 节点构造器:key,value
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int k;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.k = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
        } else {
            if (map.size() == k) {
                int delete = tail.pre.key;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                map.remove(delete);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            remove2Head(node);
        }
    }


    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 删除该节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
            // 再移动到头部
            remove2Head(node);
            return node.value;
        }
        return -1;
    }

    private void remove2Head(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        System.out.println(cache.get(1));
        cache.put(1, 0);
        cache.put(2, 2);
        System.out.println(cache.get(1));
    }

}
