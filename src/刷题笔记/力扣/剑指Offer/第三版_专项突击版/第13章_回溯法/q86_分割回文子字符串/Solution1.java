package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第13章_回溯法.q86_分割回文子字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/12 9:43 上午
 * @description
 */
public class Solution1 {
    public String[][] partition(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // 预处理
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (arr[i] == arr[j] && dp[i + 1][j - 1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(res, path, s, n, dp, 0);
        // List<List<String>> 转 String[][]，这里不重要
        String[][] ans = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new String[res.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }

    public void dfs(List<List<String>> res, List<String> path, String s, int n, boolean[][] dp, int pos) {
        if (pos == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < n; i++) {
            // s[pos:i] （闭区间）是一个回文，所以递归搜索s[i+1, s.length()-1]
            if (dp[pos][i]) {
                path.add(s.substring(pos, i + 1));
                dfs(res, path, s, n, dp, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
