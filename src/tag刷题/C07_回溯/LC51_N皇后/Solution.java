package tag刷题.C07_回溯.LC51_N皇后;

import java.util.*;

public class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 题目要求:返回二维链表,并且需要填Q或.
        // 所以初始化一个二维字符数组,初始化先放入.
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        // 回溯
        backTrack(n, 0, chessboard);
        return res;
    }


    public void backTrack(int n, int row, char[][] chessboard) {
        // 终止条件:row越过n-1,说明这是一种正确的放法
        if (row == n) {
            // 递归成功结束:处理结果,将二维数组转化为链表,再添加进res中
            res.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                // 开始递归
                backTrack(n, row + 1, chessboard);
                // 回溯,递归结束表明此次方案失败
                chessboard[row][col] = '.';
            }
        }
    }


    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < n; ++i) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45°对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135°对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
