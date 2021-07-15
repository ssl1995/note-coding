package 剑指Offer.分类版.C10_数学.剑指Offer14_剪绳子I;

public class Solution {

    // 法:数学规律法
    public int cuttingRope(int n) {
        // 题目规定:2<=n<=58
        if (n <= 3) {
            return n - 1;
        }
        // 求n能分成3的几段
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
