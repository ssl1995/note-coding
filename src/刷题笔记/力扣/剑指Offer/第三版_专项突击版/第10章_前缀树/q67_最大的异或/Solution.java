package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第10章_前缀树.q67_最大的异或;

/**
 * @author SongShengLin
 * @date 2021/10/23 11:19 上午
 * @description
 */
public class Solution {

    static class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            // 二进制只有0和1两位
            children = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode cur = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                // bit=0，如果1位置存在；bit=1，如果0位置存在
                if (cur.children[bit ^ 1] != null) {
                    xor = (xor << 1) + 1;
                    cur = cur.children[bit ^ 1];
                } else {
                    xor = xor << 1;
                    cur = cur.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                // 从高位开始建立前缀树
                int bit = (num >> i) & 1;
                if (cur.children[bit] == null) {
                    cur.children[bit] = new TrieNode();
                }
                cur = cur.children[bit];
            }
        }
        return root;
    }
}
