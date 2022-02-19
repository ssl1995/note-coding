package 学习笔记.算法面试40讲.C33_数独问题.LC37_解数独;

/**
 * @author SongShengLin
 * @date 2022/2/19 3:43 PM
 * @description
 */
public class Solution {

    /**
     * 解数独
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        dfs(board);
    }


    private boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 空白位置用'.'代替
                if (board[i][j] == '.') {
                    // 每一个空白位置用字符1-9去尝试
                    for (char c = '1'; c <= '9'; c++) {
                        // i,j位置能否放入字符c
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            // 递归下一个空白位置
                            if (dfs(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * board[row][col]能否放入c
     */
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 检查行是否有c
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            // 检查列是否有c
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            // 检查3*3的方格里是否有c
            int x = 3 * (row / 3) + i / 3;
            int y = 3 * (col / 3) + i % 3;
            if (board[x][y] != '.' && board[x][y] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] cs = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solution.solveSudoku(cs);
    }
}
