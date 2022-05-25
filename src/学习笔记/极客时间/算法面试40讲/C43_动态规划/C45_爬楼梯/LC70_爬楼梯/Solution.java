package 学习笔记.极客时间.算法面试40讲.C43_动态规划.C45_爬楼梯.LC70_爬楼梯;

/**
 * @author SongShengLin
 * @date 2022/2/20 8:43 AM
 * @description
 */
public class Solution {

    /**
     * 爬楼梯
     * 输入：n = 2
     * 输出：2
     * 输入：n = 3
     * 输出：3
     */
    public int climbStairs(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        int sum;
        for (int i = 0; i < n - 2; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        System.out.println(solution.climbStairs(n));
    }
}
