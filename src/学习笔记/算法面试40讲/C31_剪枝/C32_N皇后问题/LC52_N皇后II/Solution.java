package 学习笔记.算法面试40讲.C31_剪枝.C32_N皇后问题.LC52_N皇后II;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/2/18 9:23 AM
 * @description
 */
public class Solution {

    private int count = 0;

    /**
     * N皇后II
     * 输入：n = 4
     * 输出：2
     */
    public int totalNQueens(int n) {
        // 初始化cs二维数组，根据题目条件初始化放入.
        char[][] cs = new char[n][n];
        for (char[] c : cs) {
            Arrays.fill(c, '.');
        }

        backTrack(cs, 0, n);

        return count;
    }


    public void backTrack(char[][] cs, int i, int n) {
        // 终止条件:row越过n-1,说明这是一种正确的放法
        if (i == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; ++j) {
            // 到达一行，遍历该行的每一列是否与之前的皇后是否产生攻击
            if (isValid(cs, i, j, n)) {
                // 将有效当期位设为Q
                cs[i][j] = 'Q';
                // 递归下一行
                backTrack(cs, i + 1, n);
                // 回溯，当前有效位还原，循环开启下一行
                cs[i][j] = '.';
            }
        }
    }

    public boolean isValid(char[][] cs, int row, int col, int n) {
        // 行不用检查，因为是逐行放入cs中
        // 检查列
        for (int i = 0; i < n; ++i) {
            if (cs[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45°斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (cs[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135°反斜线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (cs[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
