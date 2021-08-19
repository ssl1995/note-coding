package 剑指Offer.分类版.C07_递归.剑指Offer13_机器人的运动范围;

public class Solution {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, 0, 0, k);
    }


    // 明确概念:机器人从(0,0)出发,行列数位和<k的坐标,只会在(0,0)的右边或者下边,每次只用递归i+1/j+1
    private int dfs(boolean[][] visited, int i, int j, int k) {
        // 递归结束，返回0: 坐标越界 or 行列坐标数位和超过k or 已经访问过
        if (i >= visited.length || j >= visited[0].length || digitSum(i) + digitSum(j) > k || visited[i][j]) {
            return 0;
        }
        // 未访问过,就设置为true,代表访问过
        visited[i][j] = true;
        // +1:当前访问位置就是一个可以访问单元格的数量,所以加1
        // i+1/j+1:机器人从(0,0)出发,所有可达解均在下边或右边,所以只用递归i+1或j+1
        return 1 + dfs(visited, i + 1, j, k) + dfs(visited, i, j + 1, k);
    }

    // 求一个数的数位和
    private int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            // 加上num的个位数，然后num/10
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
