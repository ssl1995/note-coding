package 学习笔记.算法面试40讲.C36_字典树.C37_实现字典树.LC208_实现Trie;

/**
 * @author SongShengLin
 * @date 2022/2/19 5:28 PM
 * @description
 */
public class Trie {

    static class TrieNode {
        public boolean isWordEnd;
        public TrieNode[] children;

        public TrieNode() {
            // 26个字母
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /**
     * 实现一个前缀树
     */
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWordEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
            } else {
                return false;
            }
        }
        return cur.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}
