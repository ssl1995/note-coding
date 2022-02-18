package 学习笔记.算法面试40讲.C32_N皇后问题.LC51_N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/2/18 9:23 AM
 * @description
 */
public class Solution {

    List<List<String>> res = new ArrayList<>();

    /**
     * N皇后
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     */
    public List<List<String>> solveNQueens(int n) {
        // 初始化cs二维数组，根据题目条件初始化放入.
        char[][] cs = new char[n][n];
        for (char[] c : cs) {
            Arrays.fill(c, '.');
        }

        backTrack(cs, 0, n);

        return res;
    }


    public void backTrack(char[][] cs, int i, int n) {
        // 终止条件:row越过n-1,说明这是一种正确的放法
        if (i == n) {
            res.add(char2List(cs));
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

    public List<String> char2List(char[][] cs) {
        List<String> list = new ArrayList<>();
        for (char[] c : cs) {
            // char[]直接转成String，加进list中
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
