package 学习笔记.算法面试40讲.C36_字典树.C38_二维数组中单词搜索问题.LC212_单词搜索II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2022/2/19 5:58 PM
 * @description
 */
public class Solution {
    /**
     * 单词搜索II
     * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
     * 输出：["eat","oath"]
     */
    public List<String> findWords(char[][] board, String[] words) {
        // 去重：add时会有重复
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < words.length; k++) {
                    if (dfs(board, i, j, words[k], 0)) {
                        set.add(words[k]);
                    }
                }
            }
        }
        // 结果集转成list
        return new ArrayList<>(set);
    }

    /**
     * 复用79_单词搜索的dfs
     */
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // 剪枝：防止单词搜索回退已检查过的位置
        board[i][j] = '*';

        boolean res = dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i - 1, j, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1);
        // 还原
        board[i][j] = word.charAt(index);
        return res;
    }
}
