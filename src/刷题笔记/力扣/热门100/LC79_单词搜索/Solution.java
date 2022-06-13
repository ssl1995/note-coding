package 刷题笔记.力扣.热门100.LC79_单词搜索;

/**
 * @author SongShengLin
 * @date 2022/1/29 11:05 AM
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
                // 从任意一点出发，该点为起始点，匹配成功一次就算成功
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // 剪枝：搜索过的单词，要特殊标记后，防止后面遍历重复访问
        board[i][j] = '*';
        // 从(i,j)位置上下左右都递归一遍，只要有一个匹配就成功
        boolean res = dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i - 1, j, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1);

        // 还原：访问判断过后的单词
        board[i][j] = word.charAt(index);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(solution.exist(board, word));
    }


}
