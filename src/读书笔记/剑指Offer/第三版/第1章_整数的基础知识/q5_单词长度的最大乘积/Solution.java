package 读书笔记.剑指Offer.第三版.第1章_整数的基础知识.q5_单词长度的最大乘积;

/**
 * @author SongShengLin
 * @date 2021/9/10
 */
public class Solution {
    // map法：时间复杂度O(nk+n²)
    public int maxProduct(String[] words) {
        int N = 26;
        boolean[][] flags = new boolean[words.length][N];
        for (int i = 0; i < words.length; i++) {// 记录每个单词字符是否出现过
            for (char c : words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < N; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                if (k == N) {// k遍历到N=26，说明该单词已经排查完毕，和其余单词没有重复字符=符合要求
                    int prod = words[i].length() * words[j].length();
                    res = Math.max(res, prod);
                }
            }
        }
        return res;
    }
}
