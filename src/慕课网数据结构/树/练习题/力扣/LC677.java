package 慕课网数据结构.树.练习题.力扣;

import java.util.TreeMap;

/**
 * @Author ssl
 * @Date 2020/12/15 16:19
 * @Description 677. 键值映射
 */
public class LC677 {

    private class Node {
        public int value;
        public TreeMap<Character, Node> next;

        public Node(int isWord) {
            this.value = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    public LC677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.value;
        for (Character c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }
}
