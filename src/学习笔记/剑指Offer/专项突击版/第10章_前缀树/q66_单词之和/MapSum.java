package 学习笔记.剑指Offer.专项突击版.第10章_前缀树.q66_单词之和;

/**
 * @author SongShengLin
 * @date 2021/10/23 10:43 上午
 * @description
 */
public class MapSum {

    static class TrieNode {
        public TrieNode[] children;
        public int value;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        return getSum(cur);
    }

    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int res = node.value;
        for (TrieNode child : node.children) {
            res += getSum(child);
        }
        return res;
    }
}
