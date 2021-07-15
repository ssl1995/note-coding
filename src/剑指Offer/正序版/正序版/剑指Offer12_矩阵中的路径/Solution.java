package 剑指Offer.正序版.正序版.剑指Offer12_矩阵中的路径;

public class Solution {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, char[] word, int row, int col, int k) {
        // 递归失败:越界+匹配失败/剪枝
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word[k]) {
            return false;
        }
        // 递归成功:未越界+board[row][col] = word[k]+k遍历到单词末尾
        if (k == word.length - 1) {
            return true;
        }
        // 剪枝:递归未结束,将当前元素设为空字符,防止后面递归重复访问
        board[row][col] = '\0';
        // 四个方向有一个递归匹配成功,就返回给res
        boolean res = (bfs(board, word, row + 1, col, k + 1) || bfs(board, word, row - 1, col, k + 1)
                || bfs(board, word, row, col + 1, k + 1) || bfs(board, word, row, col - 1, k + 1));
        // 回溯:将剪枝原值返回给当前元素
        board[row][col] = word[k];
        return res;
    }
}
