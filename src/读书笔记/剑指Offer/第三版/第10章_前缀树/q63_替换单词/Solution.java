package 读书笔记.剑指Offer.第三版.第10章_前缀树.q63_替换单词;

import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/10/19 8:46 上午
 * @description
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!prefix.isEmpty()) {
                // 查找出的前缀不为null，当前句子中的单词替换成该前缀
                words[i] = prefix;
            }
        }
        // 按照" "来连接一个字符串数组，返回一个字符串
        return String.join(" ", words);
    }

    static class TrieNode {
        public TrieNode[] children;
        // 判断到达该节点的路径对应的字符串是否为字典中一个完整的单词
        public boolean isWord;

        public TrieNode() {
            // 假设这颗前缀树只包含26个小写字母
            children = new TrieNode[26];
        }
    }

    /**
     * 建立前缀树
     *
     * @param dictionary 前缀的单词结合
     * @return 前缀树根节点
     */
    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        return root;
    }

    /**
     * 查找前缀
     *
     * @param root 前缀树根节点
     * @param word 从word中找前缀
     * @return 前缀
     */
    private String findPrefix(TrieNode root, String word) {
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            // 遇到已经是一个前缀  or 当前位置没有前缀 ，就停止循环
            if (cur.isWord || cur.children[c - 'a'] == null) {
                break;
            }

            sb.append(c);
            cur = cur.children[c - 'a'];
        }
        return cur.isWord ? sb.toString() : "";
    }
}
