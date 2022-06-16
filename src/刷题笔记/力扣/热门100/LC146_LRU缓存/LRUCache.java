package 刷题笔记.力扣.热门100.LC146_LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/16 10:17 AM
 * @Describe:
 */
public class LRUCache {

    static class Node {
        int key;
        int value;

        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int cap;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        size = 0;
        cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            moveToHead(node);
            return;
        }
        if (size == cap) {
            cache.remove(tail.pre.key);
            removeNode(tail.pre);
            size--;
        }

        node = new Node(key, value);
        moveToHead(node);
        cache.put(key, node);
        size++;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}
