package 学习笔记.极客时间.算法面试40讲.C36_字典树.C38_二维数组中单词搜索问题.LC212_单词搜索II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2022/2/19 6:09 PM
 * @description
 */
public class Solution1 {

    private Set<String> set = new HashSet<>();

    /**
     * 单词搜索II
     * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
     * 输出：["eat","oath"]
     * 方法:使用Trie树
     */
    public List<String> findWords(char[][] board, String[] words) {
        // 将所有单词放入前缀树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, visited, "", trie);
            }
        }

        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited, String str, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        str += board[i][j];
        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            // 放入set中
            set.add(str);
        }

        visited[i][j] = true;
        dfs(board, i + 1, j, visited, str, trie);
        dfs(board, i - 1, j, visited, str, trie);
        dfs(board, i, j + 1, visited, str, trie);
        dfs(board, i, j - 1, visited, str, trie);
        visited[i][j] = false;
    }


    /**
     * LC208_实现Trie数
     */
    class Trie {

        class TrieNode {
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

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board, words));

    }

}


