package 慕课网数据结构.树.练习题.力扣;


public class LC208_1 {
    private TrieNode root;

    public class TrieNode {
        public int path;// 表示经过了多少个当前节点
        public int end;// 表示有多少个单词以该节点结尾
        public TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            // 字典序长度为26个字符
            map = new TrieNode[26];
        }
    }

    public LC208_1() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        // 1.将字符串转变为字符数组
        char[] chs = word.toCharArray();
        TrieNode node = root;//遍历指针
        // node.path++; //好像是书中的刊物
        int index = 0;// 字符应该在数组中索引
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] chs = prefix.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return node.path != 0;
    }
}
