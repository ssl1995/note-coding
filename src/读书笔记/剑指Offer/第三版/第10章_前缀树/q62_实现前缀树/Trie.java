package 读书笔记.剑指Offer.第三版.第10章_前缀树.q62_实现前缀树;

/**
 * @author SongShengLin
 * @date 2021/10/18 9:20 上午
 * @description
 */
public class Trie {

    // 定义前缀树数据结构
    static class TrieNode {
        public TrieNode[] children;
        // 判断到达该节点的路径对应的字符串是否为字典中一个完整的单词
        public boolean isWord;

        public TrieNode() {
            // 假设这颗前缀树只包含26个小写字母
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
                cur.children[c - 'a'] = new TrieNode();
            }
            // 遍历指针指向下一个父节点
            cur = cur.children[c - 'a'];
        }
        // 循环结束，遍历指针指向word单词结尾，最后一个单词字符设置为完整的一个单词true
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
        // search是完整查找一个单词
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
        // startsWith是前缀树只要含有该前缀，就返回true
        return true;
    }
}
