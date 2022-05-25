package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第2章_面试需要的基础知识.q13_机器人的运动范围;

public class Solution1 {
    /**
     * 用全局变量res来写，dfs就不用返回int
     */
    private int res;

    public int movingCount(int m, int n, int k) {
        res = 0;
        boolean[][] visited = new boolean[m][n];
        dfs(visited, 0, 0, k);
        return res;
    }

    private void dfs(boolean[][] visited, int i, int j, int k) {
        if (i >= visited.length || j >= visited[0].length || digitSum(i) + digitSum(j) > k || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        res++;
        dfs(visited, i + 1, j, k);
        dfs(visited, i, j + 1, k);
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
