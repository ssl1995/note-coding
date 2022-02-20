package 学习笔记.算法面试40讲.C55_LRU.LC146_LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/20 5:48 PM
 * @description
 */
public class LRUCache {

    private int size;
    private int capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        // 题目规定key、value>=0,这里可以传-1表示头尾结点
        this.head = new DLinkedNode(-1, -1);
        this.tail = new DLinkedNode(-1, -1);
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        deleteNode(node);
        removeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            deleteNode(node);
            removeToHead(node);
            return;
        }

        if (size == capacity) {
            // 细节：容量满了，先清理缓存，再删除末尾结点
            cache.remove(tail.pre.key);
            deleteNode(tail.pre);
            size--;
        }

        node = new DLinkedNode(key, value);
        cache.put(key, node);
        // 更新缓存
        removeToHead(node);
        size++;
    }

    private void deleteNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void removeToHead(DLinkedNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }


    /**
     * 定义双向链表结点数据结构
     */
    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkedNode() {

        }

    }
}
