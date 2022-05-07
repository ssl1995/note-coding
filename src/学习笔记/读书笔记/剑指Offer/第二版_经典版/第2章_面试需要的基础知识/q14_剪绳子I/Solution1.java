package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第2章_面试需要的基础知识.q14_剪绳子I;

public class Solution1 {

    /**
     * 就n划分为m段(m,n均>1),求划分成m段后，各段乘积最大值
     * n的取值范围：2 <= n <= 58
     */
    public int cuttingRope(int n) {
        // 贪心解法
        // n=2，m最小为2，乘积1*1=1，返回1
        // n=3，m最小为2，乘积1*2=2，返回2
        if (n <= 3) {
            return n - 1;
        }
        // 尽可能将绳子n以3等分时，乘积最大
        int a = n / 3;
        // 求n三等分后最后一段3的余数
        int b = n % 3;
        // 余数有以下三种情况
        if (b == 0) {// 余0,直接返回3^a为最大乘积
            // 2 <= n <= 58，乘积结果不会越界
            return (int) Math.pow(3, a);
        } else if (b == 1) {// 余1,将三等分后倒数第二段中的3+最后一段的1转换为2乘2,因为3*1<2*2
            return (int) Math.pow(3, a - 1) * (2 * 2);
        }
        // 余2,直接返回3^a*(2),最后一段不需要拆分
        return (int) Math.pow(3, a) * (2);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.cuttingRope(4));
        System.out.println(solution.cuttingRope(5));
        System.out.println(solution.cuttingRope(6));
    }
}
