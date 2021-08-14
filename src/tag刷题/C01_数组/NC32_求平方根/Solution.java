package tag刷题.C01_数组.NC32_求平方根;

public class Solution {
    // 常规问法：求一个数的平方根，只用返回int
    public int sqrt(int x) {
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
                res = mid;// 记录靠近平方根的最大数
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    // 面试加问，求平方根，怎么精确到小数点后6位？
    public float calSQRT(float x) {
        float left = 0;
        float right = x;
        float standard = (float) 0.000001;
        while (Math.abs(right - left) >= standard) {
            float mid = left + (right - left) / 2;
            float midSquare = mid * mid;
            if (midSquare - x > standard) {// 右边误差大，就移动右指针
                right = mid;
            } else if (x - midSquare > standard) {// 左边误差大，就移动左指针
                left = mid;
            } else {// 达到误差标准，就返回
                return mid;
            }
        }
        return -1;// -1代表失败
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calSQRT((float) 6.000000));
    }

}
