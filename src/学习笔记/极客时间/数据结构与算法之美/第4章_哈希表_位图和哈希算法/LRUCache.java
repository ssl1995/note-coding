package 学习笔记.极客时间.数据结构与算法之美.第4章_哈希表_位图和哈希算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/1/5 8:24 AM
 * @description 数据结构与算法之美书上的LRU
 */
public class LRUCache {


    /**
     * 哈希表：缓存值和指向有序链表的指针
     */
    private Map<Integer, DLinkedNode> cache;
    /**
     * 链表实际长度
     */
    private int size;
    /**
     * 链表最大长度
     */
    private int capacity;
    /**
     * 链表头指针：存储最新访问的数据
     */
    private DLinkedNode head;
    /**
     * 链表尾指针：存储最早访问的数据
     */
    private DLinkedNode tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        this.cache = new HashMap<>();

        this.head = new DLinkedNode(-1, -1);
        this.tail = new DLinkedNode(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    /**
     * 查找
     */
    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        // 哈希表：查找链表中是否存在key对应的结点
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 删除该节点并移动到头部=最近使用过
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
        // node不存在，如果链表已满，先移除末尾元素
        if (size == capacity) {
            // 细节：容量满了，先清理缓存，再删除末尾结点
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
        // node不存在，生成新结点让如头部
        node = new DLinkedNode(key, value);
        addNodeAtHead(node);
        // 新节点加入缓存
        cache.put(key, node);
        size++;
    }

    /**
     * 删除
     */
    public void remove(int key) {
        // 哈希表：找到待删除数据
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return;
        }
        // 删除该节点，同步缓存也删除该key
        removeNode(node);
        cache.remove(node.key);
    }


    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeAtHead(DLinkedNode node) {
        // 画一个手动的循环圆圈图，手动模拟别写错
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }


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
}
