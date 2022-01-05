package 学习笔记.数据结构与算法之美.第4章_哈希表_位图和哈希算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/1/5 8:24 AM
 * @description 数据结构与算法之美书上的LRU
 */
public class LRUCache {

    /**
     * 有序链表结点=双端链表结点
     */
    private class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 哈希表：缓存值和指向有序链表的指针
     */
    private Map<Integer, DLinkedNode> cache;
    /**
     * 有序链表实际长度
     */
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode(-1, -1);
        tail = new DLinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 查找
     */
    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNodeAtHead(node);
        return node.value;
    }

    /**
     * 添加和修改
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // node存在
        if (node != null) {
            node.value = value;
            removeNode(node);
            addNodeAtHead(node);
            return;
        }
        // node不存在，且有序链表已满
        if (size == capacity) {
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
        // node不存在，有序链表未满
        node = new DLinkedNode(key, value);
        addNodeAtHead(node);
        cache.put(key, node);
        size++;
    }

    /**
     * 删除
     */
    public void remove(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return;
        }
        removeNode(node);
        cache.remove(node.key);
    }


    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeAtHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
