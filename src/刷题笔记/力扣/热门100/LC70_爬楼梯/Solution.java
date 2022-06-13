package 刷题笔记.力扣.热门100.LC70_爬楼梯;

/**
 * @author SongShengLin
 * @date 2022/1/27 8:57 AM
 * @description
 */
public class Solution {

    /**
     * 爬楼梯
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * n=1,返回1;n=2,返回2;n=3，返回3;
     */
    public int climbStairs(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int sum;
        // 从第三个数开始，到第n个数(闭区间)
        for (int i = 3; i <= n; i++) {
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
