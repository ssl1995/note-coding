package tag刷题.C05_栈和队列.NC93_LRU缓存结构;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    // 设计一个LRU缓存结构：参数是给一个二维数组和长度k。二维数组每一行存：
    // (set操作是三个数，第一个数是1，后面两个是key和value)
    // (get操作是两个数，第一个数是2，后面是key)

    // 定义Node
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

    // map<key,Node(key,value)>：缓存key
    private HashMap<Integer, Node> map = new HashMap<>();
    // 头结点和尾结点，模拟双向链表
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int k;


    // 暴露的LRU接口
    public int[] LRU(int[][] operators, int k) {
        this.k = k;
        head.next = tail;
        tail.pre = head;
        // 获得二维数组中每一行首位数字是2操作的个数=get操作的个数
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        // 生成len长度的res数组=返回的数组
        int[] res = new int[len];
        int index = 0;// index遍历res
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {// 操作数为1 = set操作
                set(operators[i][1], operators[i][2]);
            } else {// 操作数为2 = get操作
                res[index++] = get(operators[i][1]);
            }
        }
        return res;
    }

    // set:插入结点，新插入的结点一直维持在头部后面
    private void set(int key, int value) {
        if (get(key) != -1) {// key存在过，更新value即可
            map.get(key).value = value;
        } else {
            if (map.size() == k) {
                // 末尾元素的key 是待删除的节点key
                int delete = tail.pre.key;
                // 倒数第二个节点指向tail
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                map.remove(delete);
            }
            // map存新加入的结点
            Node node = new Node(key, value);
            map.put(key, node);
            // 新加入的结点=最近使用的，放回头节点后面
            remove2Head(node);
        }
    }

    // get:获得一个结点的value，每次获取的结点放到头指针后面;没有找到，返回-1
    private int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 双向链表中删除一个结点
            node.pre.next = node.next;
            node.next.pre = node.pre;
            // 删除的结点移到头结点的后面
            remove2Head(node);
            return node.value;
        }
        return -1;
    }


    // set/get的结点,最后都要插入到头结点后面
    private void remove2Head(Node node) {
        // 双向链表头插法
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ops = {{1, 1, 0}, {1, 2, 1}, {2, 1}};
        int k = 1;
        int[] res = solution.LRU(ops, k);
        System.out.println(Arrays.toString(res));
    }
}
