package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第10章_前缀树.q65_最短的单词编码;

/**
 * @author SongShengLin
 * @date 2021/10/22 9:36 上午
 * @description
 */
public class Solution {

    static class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }


    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);

        int[] total = {0};
        dfs(root, 1, total);
        return total[0];
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            // 倒序遍历word，word是后缀，倒序后就是前缀啦
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
        }
        return root;
    }

    private void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }
    }
}
