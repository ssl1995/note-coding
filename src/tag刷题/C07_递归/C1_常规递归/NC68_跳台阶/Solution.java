package tag刷题.C07_递归.C1_常规递归.NC68_跳台阶;

public class Solution {
    // 迭代法：与力扣剑指Offer10-II有很大区别的,这里的n从1开始且不需要取模
    public int jumpFloor1(int target) {
        if (target < 3) {// n从1开始
            return target;
        }
        int a = 1;// 跳上第一个台阶需要1步
        int b = 2;// 跳上第二个台阶需要2步
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    // 动态规划法
    public int jumpFloor2(int target) {
        if (target < 3) {// n从1开始
            return target;
        }
        int[] dp = new int[target];
        dp[0] = 1;// 坐标0-第一个台阶
        dp[1] = 2;// 坐标1-第二个台阶
        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }

}
