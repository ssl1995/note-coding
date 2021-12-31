package 读书笔记.牛客算法课.基础班.课8_前缀树和贪心算法.Q03_N皇后问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private int count;

    // 力扣51改编:返回n皇后可以摆放的次数
    public int solveNQueens(int n) {
        char[][] cs = new char[n][n];// 初始化cs二维数组，根据题目条件初始化放入.
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
            if (isValid(cs, i, j, n)) {
                cs[i][j] = 'Q';// cs中该位置放入Q
                backTrack(cs, i + 1, n);// 递归，后续行继续判断
                cs[i][j] = '.';// 回溯，将cs所有位置都归还为初始化的.
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

    public List<String> char2List(char[][] cs) {
        List<String> list = new ArrayList<>();
        for (char[] c : cs) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int res = solution.solveNQueens(n);
        System.out.println(res);
    }


}
