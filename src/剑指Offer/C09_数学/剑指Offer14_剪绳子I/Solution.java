package 剑指Offer.C09_数学.剑指Offer14_剪绳子I;

public class Solution {

    // 将长度为n的绳子等分为m段，使其乘积最大，m、n都是整数，n>1并且m>1，m<=n
    // 2 <= n <= 58，pow结果不会越界
    public int cuttingRope(int n) {
        // n=2，m最小为2，乘积1*1=1，返回1
        // n=3，m最小为2，乘积1*2=2，返回2
        if (n <= 3) {
            return n - 1;
        }
        // 尽可能将绳子n以3等分时，乘积最大
        // 2 <= n <= 58，乘积结果不会越界
        int a = n / 3;
        // 求n三等分后最后一段3的余数
        int b = n % 3;
        // 余数有以下三种情况
        if (b == 0) {// 余0,直接返回3^a为最大乘积
            return (int) Math.pow(3, a);
        } else if (b == 1) {// 余1,将三等分后倒数第二段中的3+最后一段的1转换为2乘2,因为3*1<2*2
            return (int) Math.pow(3, a - 1) * (2 * 2);
        }
        // 余2,直接返回3^a*(2),最后一段不需要拆分
        return (int) Math.pow(3, a) * (2);
    }
}
