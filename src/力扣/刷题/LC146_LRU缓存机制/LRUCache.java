package 力扣.刷题.LC146_LRU缓存机制;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // LRU：需要哈希表+双向链表；我们将用过的放末尾；待删除的放链表头部

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

    // LRU的数据结构:两个哨兵结点(模拟双链表，便于删除和添加),哈希表(键=node.key,值=node)
    private final ListNode head;
    private final ListNode tail;
    private final Map<Integer, ListNode> map;
    // capacity用于map.size()比较内存大小
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


    /**
     * 从缓存中取出一个数，用过的数放在链表末尾
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        // get操作代表该元素被使用了，放在链表末尾=获得一个key的时候，需要将其移动的链表末尾
        moveToTail(node, node.value);
        return node.value;
    }


    /**
     * 放入一个数进缓存，缓存满了就移除头部，未满就放入末尾
     */
    public void put(int key, int value) {
        // 如果map中包含给结点，就移动到末尾并更新
        if (map.containsKey(key)) {
            moveToTail(map.get(key), value);
        } else {
            // 不含，就先判断是否LRU满
            if (map.size() == capacity) {
                // 表头=不常用的，链表满了就删除第一个结点
                ListNode first = head.next;
                deleteNode(first);
                // 哈希表删除第一个节点
                map.remove(first.key);
            }
            ListNode node = new ListNode(key, value);
            // 链表增加一个结点，代表常用=放在末尾
            insertNode(node);
            // 哈希表增加一个<key,双向链表结点>
            map.put(key, node);
        }
    }

    /**
     * 将原node结点删除，删除后新建一个结点移动到末尾
     * 总结：用过的，都放链表后面去
     */
    private void moveToTail(ListNode node, int newValue) {
        // 先删除该节点
        deleteNode(node);
        // 移动包含更新操作：更新结点的value
        node.value = newValue;
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

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        System.out.println(cache.get(1));
        cache.put(1, 0);
        cache.put(2, 2);
        System.out.println(cache.get(1));
    }

}
