package 学习笔记.算法面试40讲.C55_LRU.LC460_LFU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/20 7:00 PM
 * @description
 */
public class LFUCache {

    private int size;
    private int capacity;
    private Map<Integer, Node> cache;
    /**
     * 频次对应的双向链表
     */
    private Map<Integer, DoubleLinkedList> freqMap;
    /**
     * 当前最小值
     */
    private int min;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // node增加频次
        addFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        // node存在就更新频次
        if (node != null) {
            node.value = value;
            addFreq(node);
        } else {
            // node不存在
            // 链表满啦，移除最不经常使用的=移除min对应的链表
            if (size == capacity) {
                DoubleLinkedList minList = freqMap.get(min);
                cache.remove(minList.tail.pre.key);
                minList.removeNode(minList.tail.pre);
                size--;
            }

            node = new Node(key, value);
            cache.put(key, node);
            // 获取频次为1的链表
            DoubleLinkedList linkedList = freqMap.get(1);
            if (linkedList == null) {
                linkedList = new DoubleLinkedList();
                freqMap.put(1, linkedList);
            }
            linkedList.addNode(node);
            size++;
            // node不存在，更新最不长使用频次=1
            min = 1;
        }
    }

    private void addFreq(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        DoubleLinkedList linkedList = freqMap.get(freq);
        linkedList.removeNode(node);
        // freq = min 且 原freq对应的链表为空
        if (freq == min && linkedList.head.next == linkedList.tail) {
            min = freq + 1;
        }

        // 更新freq
        node.freq++;

        linkedList = freqMap.get(freq + 1);
        if (linkedList == null) {
            linkedList = new DoubleLinkedList();
            freqMap.put(freq + 1, linkedList);
        }

        linkedList.addNode(node);
    }

    class DoubleLinkedList {
        Node head;
        Node tail;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        void addNode(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }
    }

    /**
     * 结点
     */
    class Node {
        int key;
        int value;
        int freq = 1;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}





