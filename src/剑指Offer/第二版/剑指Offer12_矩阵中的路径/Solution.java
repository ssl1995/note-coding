package 剑指Offer.第二版.剑指Offer12_矩阵中的路径;

public class Solution {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 递归+剪枝+回溯，当前(i,j)如果匹配，index+1
    private boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        // 递归失败:越界+匹配失败/剪枝
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[index]) {
            return false;
        }
        // 递归成功:未越界+board[row][col] = word[k]+k遍历到单词末尾
        if (index == word.length - 1) {
            return true;
        }
        // 剪枝:递归未结束,将当前元素设为空字符,防止后面递归重复访问
        board[i][j] = '\0';
        // 四个方向开始递归，记录结果给res
        boolean res = (dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1));
        // 回溯:将剪枝原值返回给当前元素
        board[i][j] = word[index];
        return res;
    }
}
