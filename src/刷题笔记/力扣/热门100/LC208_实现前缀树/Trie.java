package 刷题笔记.力扣.热门100.LC208_实现前缀树;

/**
 * @author SongShengLin
 * @date 2022/6/18 18:25
 * @description
 */
public class Trie {

    static class TrieNode {
        public TrieNode[] children;

        public boolean isWord;

        public TrieNode() {
            // 只有小写字母
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                TrieNode node = new TrieNode();
                cur.children[c - 'a'] = node;
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }

        return true;
    }
}
