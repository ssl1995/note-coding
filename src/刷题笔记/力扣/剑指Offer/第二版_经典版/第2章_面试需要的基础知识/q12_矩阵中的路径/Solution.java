package 刷题笔记.力扣.剑指Offer.第二版_经典版.第2章_面试需要的基础知识.q12_矩阵中的路径;

public class Solution {

    /**
     * 判断矩阵中，是否存在一条路径与word相同，该起点可以是矩阵中任意一个结点，但是访问过的结点不能再访问
     *
     * @param board 矩阵
     * @param word  待匹配的单词
     * @return 是否
     */
    public boolean exist(char[][] board, String word) {
        // 从任意一个坐标出发，只要有一个匹配，就返回成功
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 从(i,j)结点出发经过index步，是否能匹配word；当前(i,j)如果匹配，index+1
     */
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 递归失败:(i,j)越界或者该字符不匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        // 递归成功:未越界+board[row][col] = word[k]+k遍历到单词末尾
        if (index == word.length() - 1) {
            return true;
        }
        // 设置一个特殊值，防止重复访问（剪枝）
        board[i][j] = '\0';
        // 四个方向开始递归，记录结果给res
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        // 回溯:将设置的特殊值还原
        board[i][j] = word.charAt(index);
        return res;
    }
}
