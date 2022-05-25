package 学习笔记.极客时间.算法面试40讲.C21_递归和分治.C22_pow.LC50_pow;

/**
 * @author SongShengLin
 * @date 2022/2/17 10:43 PM
 * @description
 */
public class Solution {
    /**
     * pow(x,n)
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 方法：快速幂法
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }

            x *= x;
            b >>= 1;
        }

        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double x = 2.0;
        int n = 10;
        System.out.println(solution.myPow(x, n));
    }
}
