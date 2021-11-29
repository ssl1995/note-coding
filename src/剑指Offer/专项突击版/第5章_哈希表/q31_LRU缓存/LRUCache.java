package 剑指Offer.专项突击版.第5章_哈希表.q31_LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2021/10/5 11:18 上午
 * @description
 */
public class LRUCache {
    // LRU：需要哈希表+双向链表

    // 双向链表结点
    static class ListNode {
        public int key;
        public int value;
        public ListNode prev;
        public ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // LRU的数据结构:两个哨兵结点(便于删除和添加),哈希表(键=缓存的键,值=双向链表结点)
    private final ListNode head;
    private final ListNode tail;
    private final Map<Integer, ListNode> map;
    private final int capacity;

    // 初始化LRU
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
    }

    // 从LRU缓存中获取一个元素
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        // 获得一个key的时候，需要将其移动的链表末尾
        moveToTail(node, node.value);
        return node.value;
    }


    // 将一个元素放进LRU缓存
    public void put(int key, int value) {
        // 如果map中包含给结点，就移动到末尾并更新
        if (map.containsKey(key)) {
            moveToTail(map.get(key), value);
        } else {
            // 不含，就先判断是否LRU满
            if (map.size() == capacity) {
                ListNode first = head.next;
                // 链表删除第一个结点
                deleteNode(first);
                // 哈希表删除第一个节点
                map.remove(first.key);
            }
            ListNode node = new ListNode(key, value);
            // 链表增加一个结点
            insertNode(node);
            // 哈希表增加一个<key,双向链表结点>
            map.put(key, node);
        }
    }

    // 移动一个结点到链表末尾，并且包含更新操作
    private void moveToTail(ListNode node, int value) {
        // 先删除该节点
        deleteNode(node);
        // 移动包含更新操作：更新结点的value
        node.value = value;
        // 插入到末尾
        insertNode(node);
    }

    // 双向链表中删除一个元素
    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 双向链表末尾哨兵结点前增加一个元素
    private void insertNode(ListNode node) {
        // 在tail结点前增加一个结点
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}
