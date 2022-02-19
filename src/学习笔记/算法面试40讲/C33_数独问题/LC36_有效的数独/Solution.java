package 学习笔记.算法面试40讲.C33_数独问题.LC36_有效的数独;

/**
 * @author SongShengLin
 * @date 2022/2/19 3:09 PM
 * @description
 */
public class Solution {
    /**
     * 有效的数独
     * 输入：board =
     * [["5","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * 输出：true
     * 注意：空白格用'.'表示
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        return dfs(board);
    }


    private boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j, board[i][j])) {
                        return false;
                    }
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
                // 原本的位置不用检查
                if (i == row) {
                    continue;
                }
                return false;
            }
            // 检查列是否有c
            if (board[row][i] != '.' && board[row][i] == c) {
                if (i == col) {
                    continue;
                }
                return false;
            }
            // 检查3*3的方格里是否有c
            // i=0,1,2都属于第0个方格，所以用/3
            int x = 3 * (row / 3) + i / 3;
            // i=3,4,5都要回到0,1,2的位置，所以用%3
            int y = 3 * (col / 3) + i % 3;
            if (board[x][y] != '.' && board[x][y] == c) {
                if (x == row && y == col) {
                    continue;
                }
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
        System.out.println(solution.isValidSudoku(cs));
    }


}
