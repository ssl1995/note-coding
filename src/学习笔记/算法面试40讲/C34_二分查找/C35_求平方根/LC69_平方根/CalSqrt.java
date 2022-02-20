package 学习笔记.算法面试40讲.C34_二分查找.C35_求平方根.LC69_平方根;

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
     * 附加：求一个数x的平方根，精确到小数点后6位
     */
    public float calSqrt(int x) {
        // 所有类型都为浮点型
        float left = 0;
        float right = x;
        while (Math.abs(right - left) >= ACCURACY) {
            float mid = left + (right - left) / 2;
            float mid2 = mid * mid;
            if (mid2 - x > ACCURACY) {
                right = mid;
            } else if (x - mid2 > ACCURACY) {
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
