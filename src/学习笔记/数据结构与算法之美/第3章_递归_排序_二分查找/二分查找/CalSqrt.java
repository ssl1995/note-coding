package 学习笔记.数据结构与算法之美.第3章_递归_排序_二分查找.二分查找;

/**
 * @author SongShengLin
 * @date 2022/1/1 9:51 PM
 * @description
 */
public class CalSqrt {
    /**
     * 精度：精确到小数点后6位
     */
    private final double ACCURACY = 0.000001;

    /**
     * 求一个数x的平方根，精确到小数点后6位
     */
    public float calSqrt(int x) {
        // 所有类型都为浮点型
        float low = 0;
        float high = x;
        while (Math.abs(high - low) >= ACCURACY) {
            float mid = low + (high - low) / 2;
            float mid2 = mid * mid;
            if (mid2 - x > ACCURACY) {
                high = mid;
            } else if (x - mid2 > ACCURACY) {
                low = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * LC69，求一个数的平方根，返回整数即可
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
}
