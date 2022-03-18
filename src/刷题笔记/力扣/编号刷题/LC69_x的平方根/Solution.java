package 刷题笔记.力扣.编号刷题.LC69_x的平方根;

public class Solution {


    /**
     * x的平方根
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */
    public int mySqrt(int x) {
        // base case：x是 0 or 1 时特殊判断
        if (x <= 1) {
            return x;
        }
        // 一个数的平方根:[1,x/2]
        int left = 1;
        int right = x / 2;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // mid*mid会越界，但是/mid，mid不能为0，所以left从1开始，right不会超过x/2
            if (mid <= (x / mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int x = 2;
        System.out.println(so.mySqrt(x));
        System.out.println((int) Math.sqrt(x));
    }
}
