package 学习笔记.极客时间.算法面试40讲.C55_LRU.LC146_LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/20 5:48 PM
 * @description
 */
public class LRUCache {

    /**
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     * 解释
     * LRUCache lRUCache = new LRUCache(2);// 长度为2
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     */
    private int size;
    private int capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        // 当前链表长度
        this.size = 0;
        // 链表最大长度
        this.capacity = capacity;
        // map作为缓存，存储key，value
        this.cache = new HashMap<>(capacity);

        // 头尾虚拟指针，不存任何值:题目规定key、value>=0,这里可以传-1表示头尾结点
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
        // 操作过的数放到头部 且 删除原链表位置
        deleteNode(node);
        removeToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // 缓存里有put的值
        if (node != null) {
            // 更新缓存
            node.value = value;
            // 操作过的数放到头部 且 删除原链表位置
            deleteNode(node);
            removeToHead(node);
            return;
        }
        // 缓存里没有put的值

        // 当前链表长度=最大值：清理缓存，删除末尾结点，更新size
        if (size == capacity) {
            cache.remove(tail.pre.key);
            deleteNode(tail.pre);
            size--;
        }

        // 生成新的结点放入缓存，放到链表头部，更新size
        node = new DLinkedNode(key, value);
        cache.put(key, node);
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
