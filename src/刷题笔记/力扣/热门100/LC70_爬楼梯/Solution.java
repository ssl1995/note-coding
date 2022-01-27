package 刷题笔记.力扣.热门100.LC70_爬楼梯;

/**
 * @author SongShengLin
 * @date 2022/1/27 8:57 AM
 * @description
 */
public class Solution {

    /**
     * 爬楼梯
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
        for (int i = 2; i < n; i++) {
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
