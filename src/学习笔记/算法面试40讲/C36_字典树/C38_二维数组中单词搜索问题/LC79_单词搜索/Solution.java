package 学习笔记.算法面试40讲.C36_字典树.C38_二维数组中单词搜索问题.LC79_单词搜索;

/**
 * @author SongShengLin
 * @date 2022/2/19 5:48 PM
 * @description
 */
public class Solution {
    /**
     * 单词搜索
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // 剪枝：防止单词搜索回退已检查过的位置
        board[i][j] = '*';

        boolean res = dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i - 1, j, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1);
        // 还原
        board[i][j] = word.charAt(index);
        return res;
    }
}
