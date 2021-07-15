package 剑指Offer.正序版.正序版.剑指Offer13_机器人的运动范围;

public class Solution {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs1(visited, 0, 0, k);
        // return dfs2(visited, 0, 0, 0, 0, k);
    }


    // 法1:深度遍历法
    // 明确概念:机器人从(0,0)出发,行列数位和<k的坐标,只会在(0,0)的右边或者下边,每次只用递归i+1/j+1
    private int dfs1(boolean[][] visited, int i, int j, int k) {
        // 递归结束:行列越界 or 已经访问过
        if (i >= visited.length || j >= visited[0].length || digitSum(i) + digitSum(j) > k || visited[i][j]) {
            return 0;
        }
        // 未访问过,就设置为true,代表访问过
        visited[i][j] = true;
        // +1:当前访问位置就是一个可以访问单元格的数量,所以加1
        // i+1/j+1:机器人从(0,0)出发,所有可达解均在下边或右边,所以只用递归i+1或j+1
        return 1 + dfs1(visited, i + 1, j, k)
                + dfs1(visited, i, j + 1, k);
    }

    // 求行列坐标的数位和
    private int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            // 求一个数字的个位数
            sum += num % 10;
            // 接着求10位数,依次类推
            num = num / 10;
        }
        return sum;
    }

    // 法2:利用规律计算行列的数位和,取消掉digitSum函数,函数签名里增加sumI,sumJ
    // 设二维坐标(i,j),i的数位和规律:(i + 1) % 10 == 0 ? sumI - 8 : sumI + 1
    private int dfs2(boolean[][] visited, int i, int j, int sumI, int sumJ, int k) {
        if (i >= visited.length || j >= visited[0].length || sumI + sumJ > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        // sumI:i的数位和。sumJ:j的数位和
        // 进位:9到10的数位和9和2,说明进位后,数位和为上一轮sum-8
        // 不进位:8到9的数位和8和9,说明未进位,数位和为上一轮sum+1
        return 1 + dfs2(visited, i + 1, j, (i + 1) % 10 == 0 ? sumI - 8 : sumI + 1, sumJ, k)
                + dfs2(visited, i, j + 1, sumI, (j + 1) % 10 == 0 ? sumJ - 8 : sumJ + 1, k);
    }
}
