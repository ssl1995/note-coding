package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第11章_二分查找.q72_求平方根;

/**
 * @author SongShengLin
 * @date 2021/11/5 9:44 上午
 * @description
 */
public class Solution {
    // n是非负整数，确定平方根，只返回整数部分
    public int mySqrt(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 只返回整数部分，只需要保证 m² <= n < (m+1)²
            if (mid <= n / mid) {
                if ((mid + 1) > n / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 0<=n<整数最大值-1，于是失败返回0
        return 0;
    }
}
