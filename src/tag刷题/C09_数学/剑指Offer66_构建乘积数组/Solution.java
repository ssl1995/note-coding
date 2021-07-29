package tag刷题.C09_数学.剑指Offer66_构建乘积数组;

public class Solution {

    // 构建乘积数组,不能使用除法
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[]{};
        }
        int n = a.length;
        // 第一个for:b[i]表示a[0...i-1]所有数的乘积
        // 第二个for:b[i]表示a[0...i-1,i+1,...n-1]所有数的乘积
        int[] b = new int[n];
        b[0] = 1;
        int temp = 1;
        // 计算下三角的乘积
        for (int i = 1; i < n; i++) {
            // a[0...i-1]所有数的乘积:上一轮b[i-1]*a中遍历到的数
            b[i] = b[i - 1] * a[i - 1];
        }
        // 上一轮计算下三角结束:b[len-1]的结果已确定
        // 开始从n-2往后遍历,计算上三角的乘积
        for (int i = n - 2; i >= 0; i--) {
            // temp为i之后的数相乘的结果
            temp *= a[i + 1];
            // b[i]整体=上三角*下三角
            b[i] *= temp;
        }
        return b;
    }
}
