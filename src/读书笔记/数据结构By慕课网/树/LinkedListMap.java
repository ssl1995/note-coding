package 读书笔记.数据结构By慕课网.树;

/**
 * @Author ssl
 * @Date 2020/12/7 17:31
 * @Description
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private Node dummyNode;
    private int size;

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        public Node(K key) {
            this(key, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    public LinkedListMap() {
        dummyNode = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyNode.next = new Node(key, value, dummyNode.next);
            size++;
        } else {
            // 可以选择抛出异常
            // 这里选择更新value的值
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.key == key) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        // 返回Node 等价于 !=null
        return getNode(key) != null;
    }

    private Node getNode(K key) {
        Node cur = dummyNode.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
