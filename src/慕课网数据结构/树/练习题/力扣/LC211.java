package 慕课网数据结构.树.练习题.力扣;

import java.util.TreeMap;

public class LC211 {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    public LC211() {
        root = new Node();
    }

    public void addWord(String word) {
        // 遍历指针
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }
    // 递归查找
    private boolean search(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return search(node.next.get(c), word, index + 1);
        } else {
            for (char nextChar : node.next.keySet()) {
                if (search(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
