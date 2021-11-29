package 剑指Offer.第三版.第11章_二分查找.q71_按权重生成随机数;

import java.util.Random;

/**
 * @author SongShengLin
 * @date 2021/11/4 9:29 上午
 * @description
 */
public class Solution {

    private int[] sums;
    private int total;

    public Solution(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    // 根据权重比例，随机选择一个下标
    public int pickIndex() {
        Random random = new Random();
        int p = random.nextInt(total);
        int left = 0;
        int right = sums.length;
        // 二分查找确定第一个>p的数下标，并返回
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] > p) {
                if (mid == 0 || sums[mid - 1] <= p) {
                    return mid;
                }
                // 如果 sums[mid - 1] > p，第一个>p的就在前面
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 测试git可用
        return -1;
    }
}
